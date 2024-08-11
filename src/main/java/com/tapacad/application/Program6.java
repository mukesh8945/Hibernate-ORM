package com.tapacad.application;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.tapacad.model.Student;

public class Program6 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            // Create Session Factory
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            
            // Create Session
            session = sessionFactory.openSession();
            
            // Create Transaction
            Transaction transaction = session.beginTransaction();
            
            // CRUD Operation
            String hql = "UPDATE Student s SET s.marks = 90 WHERE s.marks < 90";
            Query query = session.createQuery(hql);
            int i = query.executeUpdate();
            System.out.println(i + " records updated.");
            
            transaction.commit();
            
        } finally {
            // Closing Resources
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
