package org.examples.HAS_A_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class ManyToManyClient {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("has_a_manyToMany_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Course course1 = new Course();
        course1.setCname("java");

        Course course2 = new Course();
        course2.setCname("spring");

        Course course3 = new Course();
        course3.setCname("hibernate");

        Course course4 = new Course();
        course4.setCname("spring-boot");

        Set<Course> courseSet1 = new HashSet<Course>();
        courseSet1.add(course1);
        courseSet1.add(course3);
        courseSet1.add(course4);

        Set<Course> courseSet2 = new HashSet<Course>();
        courseSet2.add(course2);
        courseSet2.add(course3);

        Faculty faculty1 = new Faculty();
        faculty1.setFname("yogesh");
        faculty1.setCourses(courseSet1);

        Faculty faculty2 = new Faculty();
        faculty2.setFname("ashesha");
        faculty2.setCourses(courseSet2);


        /*session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);*/

        session.save(faculty1);
        session.save(faculty2);

        tx.commit();
        session.close();
        sf.close();
    }
}
