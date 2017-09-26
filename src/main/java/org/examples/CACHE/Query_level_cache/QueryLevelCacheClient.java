package org.examples.CACHE.Query_level_cache;

import org.examples.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class QueryLevelCacheClient {

    public static void main (String[] args){

        Configuration cfg = new Configuration();
        cfg.configure("query_level_cache_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Query query1 = session.createQuery("from Employee");

        // IMPORTANT
        // set below to true in order to cache Query
        query1.setCacheable(true);
        List<Employee> list1 = query1.list();

        System.out.println("-=======First query result ======");
        for (Employee emp:list1){
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }


        Query query2 = session.createQuery("from Employee");

        // Always set true even though query1 already cached or else no caching achieved
        query2.setCacheable(true);
        List<Employee> list2 = query2.list();
        System.out.println("-=======Second query result ======");

        for (Employee emp:list2){
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }

        session.close();
        sf.close();
    }
}
