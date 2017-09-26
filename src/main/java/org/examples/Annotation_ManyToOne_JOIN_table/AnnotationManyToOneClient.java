package org.examples.Annotation_ManyToOne_JOIN_table;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class AnnotationManyToOneClient {


    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("annotation_manyToOne_joinTable_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Publisher_1 p1 = new Publisher_1();
        p1.setPublisherName("p1");
        p1.setCode("123");
        p1.setAddress("mumbai");


        Book_1 b1 = new Book_1();
        b1.setName("b1");
        b1.setPrice("$100");
        b1.setPublisher1(p1);

        Book_1 b2 = new Book_1();
        b2.setName("b1");
        b2.setPrice("$100");
        b2.setPublisher1(p1);


        session.save(b1);
        session.save(b2);
        session.save(p1);

        tx.commit();
        session.close();
        sf.close();
    }
}
