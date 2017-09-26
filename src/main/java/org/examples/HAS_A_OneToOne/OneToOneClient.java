package org.examples.HAS_A_OneToOne;

import org.examples.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class OneToOneClient {


    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("has_a_oneToOne_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setName("abc");

        Customer customer2 = new Customer();
        customer2.setName("pqr");

        Address address1 = new Address();
        address1.setAddr("Mumbai");
        address1.setPinCode(12345);
        address1.setCustomer(customer1);

        Address address2 = new Address();
        address2.setAddr("Pune");
        address2.setPinCode(456789);
        address2.setCustomer(customer2);

        session.save(address1);
        session.save(address2);
        session.save(customer1);
        session.save(customer2);

        tx.commit();
        session.close();
        sf.close();
    }
}
