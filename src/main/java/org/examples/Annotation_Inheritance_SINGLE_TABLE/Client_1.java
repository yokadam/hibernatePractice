package org.examples.Annotation_Inheritance_SINGLE_TABLE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client_1 {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("annotation_inheritance_singleTable_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setCompanyName("CTS");

        HardwareEmp h1 = new HardwareEmp();
        h1.setDept("mech");
        h1.setwHours(8);

        SoftwareEmp s1 = new SoftwareEmp();
        s1.setSalary(10000);
        s1.setSkills("java");

        session.save(e1);
        session.save(h1);
        session.save(s1);

        tx.commit();
        session.close();
        sf.close();
    }
}
