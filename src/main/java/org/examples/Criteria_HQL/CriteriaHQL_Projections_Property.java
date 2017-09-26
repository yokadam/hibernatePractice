package org.examples.Criteria_HQL;

import org.examples.model.Employee;
import org.examples.model.Employee_Criteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.List;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class CriteriaHQL_Projections_Property {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate_criteria_query.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee_Criteria.class);

        // 1. Single Projection by only single property ex. select name from Employee_Criteria

        Projection projection = Projections.property("name");

        // multiple setProjection is not possible. Last setProjection will always override first setProjection statement.
        // for ex.
        // criteria.setProjection(projection1);
        // criteria.setProjection(projection2);
        // So projection2 will override projection1
        // hence result will be according ot projection2
        criteria.setProjection(projection);

        List<String> list = criteria.list();

        for (String name:list){
            System.out.println(name);
        }

        // 1. Projection by multiple properties ex. select id, name, salary from Employee_Criteria


        Criteria criteria1 = session.createCriteria(Employee_Criteria.class);

        Projection p1 = Projections.property("id");
        Projection p2 = Projections.property("name");
        Projection p3 = Projections.property("salary");

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(p1);
        projectionList.add(p2);
        projectionList.add(p3);

        criteria1.setProjection(projectionList);

        List<Object[]> Employee_CriteriaList = criteria1.list();

        for (Object[] emp:Employee_CriteriaList){

            System.out.println("ID="+ emp[0]);
            System.out.println("NAME="+ emp[1]);
            System.out.println("SALARY="+ emp[2]);

        }

        tx.commit();
        session.close();
        sf.close();

    }
}
