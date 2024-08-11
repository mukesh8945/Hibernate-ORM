package com.tapacad.application;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Student;

public class Program9 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//			 Create Session Factory
			sessionFactory =  new Configuration().
					configure().addAnnotatedClass(Student.class).
					buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
			 String hql="DELETE FROM Student s WHERE s.marks = 90";
			 Query query =session.createQuery(hql);
			 int i = query.executeUpdate();
			 System.out.println(i);
			
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
	}


