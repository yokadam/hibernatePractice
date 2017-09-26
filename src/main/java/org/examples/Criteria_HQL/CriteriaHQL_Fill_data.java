package org.examples.Criteria_HQL;

import org.examples.model.Employee;
import org.examples.model.Employee_Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class CriteriaHQL_Fill_data {

    public static void main(String args []){


        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate_criteria_query.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Employee_Criteria e1 = new Employee_Criteria();
        e1.setName("abc");
        e1.setDepartemnt("mech");
        e1.setSalary(10000);

        Employee_Criteria e2 = new Employee_Criteria();
        e2.setName("xyz");
        e2.setDepartemnt("Elex");
        e2.setSalary(20000);

        Employee_Criteria e3 = new Employee_Criteria();
        e3.setName("pqr");
        e3.setDepartemnt("comp");
        e3.setSalary(40000);

        session.save(e1);
        session.save(e2);
        session.save(e3);
        tx.commit();
        session.close();
        sf.close();

    }


}
