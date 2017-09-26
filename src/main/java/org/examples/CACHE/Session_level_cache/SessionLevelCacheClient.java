package org.examples.CACHE.Session_level_cache;

import org.examples.IS_A_REALTIONSHIP.model.Admin;
import org.examples.IS_A_REALTIONSHIP.model.CompanyEmployee;
import org.examples.IS_A_REALTIONSHIP.model.HardwareCompanyEmployee;
import org.examples.IS_A_REALTIONSHIP.model.SoftwareCompanyEmployee;
import org.examples.model.Employee;
import org.examples.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class SessionLevelCacheClient {

    public static void main (String[] args){

        Configuration cfg = new Configuration();
        cfg.configure("session_level_cache_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session1 = sf.openSession();

        Employee emp1 = (Employee) session1.get(Employee.class,1);
        System.out.println ("By session 1 and first time "+ emp1.getName());
        Employee emp2 = (Employee) session1.get(Employee.class,1);
        System.out.print("By session 1 and second time "+ emp2.getName());

        session1.close();

        Session session2 = sf.openSession();

        Employee emp3 = (Employee) session2.get(Employee.class,1);
        System.out.println ("By session 2 and first time "+ emp3.getName());

        session2.close();
        sf.close();
    }
}
