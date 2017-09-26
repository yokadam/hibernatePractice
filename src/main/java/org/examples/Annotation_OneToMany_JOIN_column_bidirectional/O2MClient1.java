package org.examples.Annotation_OneToMany_JOIN_column_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class O2MClient1 {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("annotation_oneToMany_join_column_bidirectional_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();


        Book b1 = new Book();
        b1.setBname("BOOK1");

        Chapter c1 = new Chapter();
        c1.setCname("CH1");
        c1.setPages(10);
        c1.setBook(b1);
        Chapter c2 = new Chapter();
        c2.setCname("CH2");
        c2.setPages(20);
        c2.setBook(b1);

        Set<Chapter> set = new HashSet<Chapter>();
        set.add(c1);
        set.add(c2);

        b1.setChapters(set);

        session.save(b1);

        tx.commit();
        session.close();
        sf.close();

    }
}
