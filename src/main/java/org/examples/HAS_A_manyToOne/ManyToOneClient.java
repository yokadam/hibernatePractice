package org.examples.HAS_A_manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class ManyToOneClient {


    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("has_a_manyToOne_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Actor actor = new Actor();
        actor.setName("Ameer Khan");

        Movies movie1 = new Movies();
        movie1.setName("PK");
        movie1.setActor(actor);

        Movies movie2 = new Movies();
        movie2.setName("Lagaan");
        movie2.setActor(actor);

        session.save(actor);

        // <set name="movies" cascade="all"> cascade set to all so no need pf below statements
        session.save(movie1);
        session.save(movie2);



        tx.commit();
        session.close();
        sf.close();
    }
}
