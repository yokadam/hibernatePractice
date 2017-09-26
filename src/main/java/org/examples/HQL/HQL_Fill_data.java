package org.examples.HQL;

import org.examples.model.OldEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class HQL_Fill_data {

    public static void main(String args []){


        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        OldEmployee e1 = new OldEmployee();
        e1.setName("abc");
        e1.setDepartemnt("mech");
        e1.setSalary(10000);

        OldEmployee e2 = new OldEmployee();
        e2.setName("xyz");
        e2.setDepartemnt("Electronics");
        e2.setSalary(20000);

        session.save(e1);
        session.save(e2);
        tx.commit();
        session.close();
        sf.close();

    }


}
