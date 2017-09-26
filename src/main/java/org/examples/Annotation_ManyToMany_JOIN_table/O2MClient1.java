package org.examples.Annotation_ManyToMany_JOIN_table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class O2MClient1 {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("annotation_manyToMany_join_table_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Book b1 = new Book();
        b1.setBname("BOOK1");

        Book b2 = new Book();
        b2.setBname("BOOK2");

        Chapter c1 = new Chapter();
        c1.setCname("CH1");
        c1.setPages(10);
        Chapter c2 = new Chapter();
        c2.setCname("CH2");
        c2.setPages(20);
        Chapter c3 = new Chapter();
        c3.setCname("CH3");
        c3.setPages(30);

        Set<Chapter> set = new HashSet<Chapter>();
        set.add(c1);
        set.add(c2);

        Set<Chapter> set2 = new HashSet<Chapter>();
        set2.add(c3);
        set2.add(c2);

        b1.setChapters(set);
        b2.setChapters(set2);

        session.save(b1);
        session.save(b2);


        tx.commit();
        session.close();
        sf.close();

    }
}
