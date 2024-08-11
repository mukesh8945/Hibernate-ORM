package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Student;

public class Program5 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
//			  Create Session Factory
			sessionFactory =  new Configuration().
					configure().addAnnotatedClass(Student.class).
					buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
			
//			    Student student =session.get(Student.class, 5);
//			    student.setMarks(90);
//			    session.update(student);
			
			Student s = new Student(9,"elton","elton@gmail.com",34);
			session.saveOrUpdate(s);
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
	}


