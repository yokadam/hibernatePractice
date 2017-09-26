package org.examples.CACHE.sessionFactory_level_cache;

import org.examples.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class DataFillUP {

    public static void main (String[] args){

        Configuration cfg = new Configuration();
        cfg.configure("session_level_cache_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp1 = new Employee( "abc", "mech", 10000);
        Employee emp2 = new Employee("pqr", "elex", 20000);
        Employee emp3 = new Employee("xyz", "chem", 40000);


        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        
        tx.commit();
        session.close();
        sf.close();
    }
}
