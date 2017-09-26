package org.examples.Annotation_ManyToOne_JOIN_column;


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
        cfg.configure("annotation_manyToOne_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Publisher p1 = new Publisher();
        p1.setPublisherName("p1");
        p1.setCode("123");
        p1.setAddress("mumbai");


        Book b1 = new Book();
        b1.setName("b1");
        b1.setPrice("$100");
        b1.setPublisher(p1);

        Book b2 = new Book();
        b2.setName("b1");
        b2.setPrice("$100");
        b2.setPublisher(p1);

        session.save(b1);
        session.save(b2);

        tx.commit();
        session.close();
        sf.close();
    }
}
