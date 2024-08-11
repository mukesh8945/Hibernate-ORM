package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Student;

public class GenerationType {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//		       Create Session Factory
			         sessionFactory =  new Configuration().
					 configure().addAnnotatedClass(Student.class).
					 buildSessionFactory();
			
//				Create Session
			    session = sessionFactory.openSession();
			
//				Create Transaction
			    Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
			    Student student=new Student();
			    student.setName("bob");
			    student.setEmail("bob@gmail.com");
			    
			    session.save(student);
			
			
			
			
			
			
			
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
		

	}


