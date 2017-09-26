package org.examples.HQL;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class HQL_delete {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "delete from Employee where id =4 ";
        Query del_query = session.createQuery(hql);

        int afftectedRowsCount = del_query.executeUpdate();

        System.out.print("Rows affected= "+afftectedRowsCount);

        tx.commit();
        session.close();
        sf.close();

    }


}
