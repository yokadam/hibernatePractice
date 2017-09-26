package org.examples.Criteria_HQL;

import org.examples.model.Employee;
import org.examples.model.Employee_Criteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class CriteriaHQL_Projections_Aggregation {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate_criteria_query.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee_Criteria.class);

        // 1. get Avg salary
        Projection projection = Projections.avg("salary");
        criteria.setProjection(projection);

        Double avgSalary = (Double)criteria.uniqueResult();

        System.out.println("Avg. salary is "+avgSalary);

        // 2. get max salary
        Criteria criteria1 = session.createCriteria(Employee_Criteria.class);
        Projection projection1 = Projections.max("salary");
        criteria1.setProjection(projection1);

        Integer maxSalary = (Integer) criteria1.uniqueResult();

        System.out.println("MAx. salary is "+maxSalary);

        tx.commit();
        session.close();
        sf.close();

    }
}
