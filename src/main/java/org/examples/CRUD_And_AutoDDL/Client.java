package org.examples.CRUD_And_AutoDDL;


import org.examples.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 27.08.17.
 */
public class Client {

    public static void main (String[] args){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        //AutoDDL(session);

        InsertDataWithSaveMethod(session);
        //InsertDataWithPersistMethod(session);
        //InsertDataWithSaveOrUpdateMethod(session);

        //UpdateDataWithUpdateMethod(session);
        //UpdateDataWithMergeMethod(session);
        //differenceBetweenUpdateAndMergeMethods(session);

        //delete(session);

        session.close();
        sessionFactory.close();
    }

    private static void delete(Session session) {

        // This operation costs in select query first and if it finds
        // the record then delete query or else if no record found then nothing.

        Student student = new Student();
        student.setId(1);

        // Without transaction commit, no data saved to Database
        Transaction tx = session.beginTransaction();

        session.delete(student);
        tx.commit();
    }

    private static void differenceBetweenUpdateAndMergeMethods(Session session) {

        // Run only CODE-1 or  CODE-2 at a time

        Transaction tx = session.beginTransaction();

        //---------------------------------------
// CODE-1
        // below code patch will throw exception
        // exception: A different object with the same identifier value was already associated with the session

        /*session.get(Student.class,1); // Student object associated with sesssion now

        Student student = new Student();
        student.setId(1);
        student.setName("yogesh5");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(400);

        session.update(student);*/

        //---------------------------------------
//CODE-2

        // below code patch will throw exception even though same student record is in associated with sesssion
        session.get(Student.class,1); // Student object associated with sesssion now

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("yogesh5");
        student1.setEmail("yogesha@gmail.com");
        student1.setMarks(4000);

        session.merge(student1);


        //---------------------------------------
        tx.commit();

    }

    private static void UpdateDataWithMergeMethod(Session session) {

        Student student = new Student();
        student.setId(7);
        student.setName("yogesh5");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(400);

        // merge -->
        // either 'select + Insert' OR 'select + update' query execution
        // depending on record to be updated already exists or not.


        // Without transaction commit, no data saved to Database
        Transaction tx = session.beginTransaction();

        session.merge(student);
        tx.commit();
    }

    private static void UpdateDataWithUpdateMethod(Session session) {

        // there is select query execution happens, only update query executed
        // thats why Record (which is going to be updated) should exists in DB or else exception thrown

        Student student = new Student();
        student.setId(1);
        student.setName("yogesh");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(300);


        // Without transaction commit, no data saved to Database
        Transaction tx = session.beginTransaction();

        session.update(student);
        tx.commit();
    }

    private static void InsertDataWithSaveMethod(Session session) {


        // insert query only
        // if ran twice for same record will result in uniquekeyviolation exception
        Student student = new Student();
        student.setId(1);
        student.setName("yogesh");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(200);

        // With or Without transaction commit, data saved to Database
        Transaction tx = session.beginTransaction();

        Integer id = (Integer) session.save(student);
        tx.commit();

        System.out.print(id);

    }

    private static void InsertDataWithPersistMethod(Session session) {

        Student student = new Student();
        student.setId(1);
        student.setName("yogesh");
        student.setEmail("yogesha@gmail.com");
        student.setMarks(200);


        // Without transaction commit, no data saved to Database
        Transaction tx = session.beginTransaction();

        session.persist(student);
        tx.commit();


    }

    private static void InsertDataWithSaveOrUpdateMethod(Session session) {

        Student student = new Student();
        student.setId(3);
        student.setName("ddddd");
        student.setEmail("dddd@gmail.com");
        student.setMarks(200);

        // SaveOrUpdate -->
        // either 'select + Insert' OR 'select + update' query execution
        // depending on record to be updated already exists or not.


        // Without transaction commit, no data saved to Database
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student);
        tx.commit();


    }

    private static void AutoDDL(Session session) {
        Student student = new Student();
        student.setId(2);
        student.setName("ashesha");
        student.setEmail("ashesha@gmail.com");
        student.setMarks(200);

        Transaction tx = session.getTransaction();
        tx.begin();
        session.save(student);

        tx.commit();


        session.evict(student);

        // property name="hbm2ddl.auto">create-drop</property> if its set
        // then below line will drop all tables
        //sf.close();
    }
}
