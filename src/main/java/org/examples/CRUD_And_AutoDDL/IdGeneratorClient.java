package org.examples.CRUD_And_AutoDDL;


import org.examples.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 27.08.17.
 */
public class IdGeneratorClient {

    public static void main (String[] args){

        Student student1 = getStudent1();
        Student student2 = getStudent2();

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(student1);

        tx.commit();

        Transaction tx2 = session.beginTransaction();
        session.save(student2);

        tx2.commit();
        session.close();
        sessionFactory.close();
    }

    private static Student getStudent1() {
        Student student = new Student();
        student.setId(7);
        student.setName("yogesh5");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(400);
        return student;
    }

    private static Student getStudent2() {
        Student student = new Student();
        student.setId(7);
        student.setName("yogesh5");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(400);
        return student;
    }

}
