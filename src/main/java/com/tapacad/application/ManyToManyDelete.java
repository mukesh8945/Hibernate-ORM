package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Employee;
import com.tapacad.model.Project;

public class ManyToManyDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//			 Create Session Factory
			        sessionFactory =  new Configuration().
					configure().addAnnotatedClass(Employee.class).
					addAnnotatedClass(Project.class).
					buildSessionFactory();
			
//				Create Session
			    session = sessionFactory.openSession();
			
//				Create Transaction
			    Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
//			    Project project = session.get(Project.class, 1);
//			    session.delete(project);
			    
			     Employee employee =session.get(Employee.class, 3);
			     session.delete(employee);
			    
			    
			
			
			
			
			
			
			
			
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	

	}


