package org.examples.HQL;

import org.examples.model.Employee;
import org.examples.model.OldEmployee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class HQL_select {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // When you are sure that only one record is possible from query
        String hql1 = "from OldEmployee where id = 1";
        Query query = session.createQuery(hql1);
        OldEmployee emp = (OldEmployee) query.uniqueResult();

        System.out.println(emp.getId());
        System.out.println(emp.getName());
        //==================================

        // When you select only one column and also sure that only one record is possible
        String hql2 = "select name from OldEmployee where id =1";
        Query query2 = session.createQuery(hql2);
        String name = (String) query2.uniqueResult();

        System.out.println(name);
        //==================================

        // select one column and When more than one record founds

        String hql3 = "select name from OldEmployee";
        Query query3 = session.createQuery(hql3);
        List<String> nameList = query3.list();

        for (String name1: nameList){
            System.out.println(name1);
        }

        // select two column and When more than one record founds

        String hql4 = "select name , salary from OldEmployee";
        Query query4 = session.createQuery(hql4);
        List<Object[]> objects = query4.list();

        for (Object[] obj: objects){

            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }


        // select * (all columns) and When more than one record founds

        String hql5 = "from OldEmployee";
        Query query5 = session.createQuery(hql5);
        List<OldEmployee> employees = query5.list();

        for (OldEmployee employee: employees){
            System.out.println(employee.getName());
        }

        tx.commit();
        session.close();
        sf.close();

    }


}
