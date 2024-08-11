package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Student;

public class Program2 {
	public static void main(String[]args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//			Create Session Factory
			
			
//				Second methods  Create Session Factory
			sessionFactory =  new Configuration().
					configure().addAnnotatedClass(Student.class).
					buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
			Student s = session.get(Student.class,1);
			System.out.println(s);
			
			
			
			
			
			
			
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
		
	}

	