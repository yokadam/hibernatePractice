package org.examples.Criteria_HQL;

import org.examples.model.Employee;
import org.examples.model.Employee_Criteria;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class CriteriaHQL_Restrictions {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate_criteria_query.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);

        // 1. Single Restriction : where id = 1
        Criterion criterion = Restrictions.eq("id",1);
        criteria.add(criterion);

        Employee_Criteria emp = (Employee_Criteria) criteria.uniqueResult();
        System.out.println(emp.getName());


        // 2. Multiple Restriction : where id = 1 and name = 'abc'
        Criteria criteria1 = session.createCriteria(Employee_Criteria.class);
        Criterion criterion1 = Restrictions.eq("id",1);
        Criterion criterion2 = Restrictions.eq("name","abc");

        criteria1.add(criterion1);
        criteria1.add(criterion2);

        Employee_Criteria emp1 = (Employee_Criteria) criteria1.uniqueResult();
        System.out.println(emp1.getName());

        tx.commit();
        session.close();
        sf.close();

    }


}
