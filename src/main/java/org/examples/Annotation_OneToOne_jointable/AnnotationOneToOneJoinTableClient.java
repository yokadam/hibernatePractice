package org.examples.Annotation_OneToOne_jointable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class AnnotationOneToOneJoinTableClient {


    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("annotation_oneToOne_Join_table_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Address a1 = new Address();
        a1.setPinCode("12345");
        a1.setState("MH");

        Student s1 = new Student();
        s1.setName("Yogesh");
        s1.setAddress(a1);

//        session.save(a1);
        session.save(s1);

        tx.commit();
        session.close();
        sf.close();
    }
}
