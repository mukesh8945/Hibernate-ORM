package com.tapacad.application;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tapacad.model.Student;

public class Program3 {

	public static void main(String[] args) {
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
		String query ="From Student";
		Query createQuery=session.createQuery(query);
		List students =createQuery.list();
		display(students);
		
			
			
			
			
			
			
			
			
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
	static void display(List students) {
		for(Object student : students) {
			System.out.println(student);
		}
	}
	

	}


