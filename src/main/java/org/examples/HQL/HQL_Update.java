package org.examples.HQL;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class HQL_Update {

    public static void main(String args []){

        Configuration cfg = new Configuration();
        cfg.configure("hql_hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "update Employee set name = 'yogesh' where id = 1";
        Query query = session.createQuery(hql);

        int afftectedRowsCount = query.executeUpdate();
        System.out.print("Rows affected= "+afftectedRowsCount);

        tx.commit();
        session.close();
        sf.close();

    }


}
