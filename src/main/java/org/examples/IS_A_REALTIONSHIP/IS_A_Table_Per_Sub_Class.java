package org.examples.IS_A_REALTIONSHIP;

import org.examples.IS_A_REALTIONSHIP.model.Admin;
import org.examples.IS_A_REALTIONSHIP.model.HardwareCompanyEmployee;
import org.examples.IS_A_REALTIONSHIP.model.SoftwareCompanyEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class IS_A_Table_Per_Sub_Class {

    public static void main (String[] args){

        Configuration cfg = new Configuration();
        cfg.configure("is_a_tablePerSubclass_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        SoftwareCompanyEmployee emp1 = new SoftwareCompanyEmployee( "abc", "abc@gmail.com", 10000,"java");
        HardwareCompanyEmployee emp2 = new HardwareCompanyEmployee("pqr", "pqr@gmail.com", 20000,10);
        Admin emp3 = new Admin("xyz", "xyz@gmail.com", 40000,"finance");


        session.save(emp1);
        session.save(emp2);
        session.save(emp3);

        tx.commit();
        session.close();
        sf.close();
    }
}
