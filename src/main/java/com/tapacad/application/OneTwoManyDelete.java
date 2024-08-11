package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Orders;

public class OneTwoManyDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//	 Create Session Factory
			sessionFactory =  new Configuration().
					          addAnnotatedClass(Customer.class).
					          configure().addAnnotatedClass(CustomerDetails.class).
					          addAnnotatedClass(Orders.class).
					          buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
			
//			Deleting Customer
			
//			Customer customer =session.get(Customer.class,1);
//			session.delete(customer);
			
			
//			Deleting Order
			Orders order = session.get(Orders.class, 706);
			session.delete(order);
		
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	

	}


