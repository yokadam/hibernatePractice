package org.examples.HAS_A_OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class OneToManyClient {


    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("has_a_oneToMany_hibernate.cfg.xml");


        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        Movies movie1 = new Movies();
        movie1.setName("PK");

        Movies movie2 = new Movies();
        movie2.setName("Lagaan");

        Set<Movies> movies = new HashSet<Movies>();
        movies.add(movie1);
        movies.add(movie2);

        Actor actor = new Actor();
        actor.setName("Ameer Khan");
        actor.setMovies(movies);

        session.save(actor);

        // <set name="movies" cascade="all"> cascade set to all so no need pf below statements
        //session.save(movie1);
        //session.save(movie2);


        tx.commit();
        session.close();
        sf.close();
    }
}
