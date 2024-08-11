package com.tapacad.application;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.tapacad.model.Student;

public class Program4 {

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
            String hql = "FROM Student s WHERE s.marks > 90 OR s.name LIKE 'C%'";
            Query query = session.createQuery(hql);
            List<Student> students = query.getResultList();
            display(students);
            
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

    private static void display(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
