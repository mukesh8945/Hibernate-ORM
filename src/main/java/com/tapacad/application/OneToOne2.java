package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne2 {

	public static void main(String[] args) {
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
//  Create Session Factory
		sessionFactory =  new Configuration().
				configure().addAnnotatedClass(Customer.class).
				addAnnotatedClass(CustomerDetails.class).
				buildSessionFactory();
		
//				Create Session
		session = sessionFactory.openSession();
		
//				Create Transaction
		Transaction transaction = session.beginTransaction();
		
//				CRUD Operation
//		 Customer customer  =session.get(Customer.class, 1);
//		CustomerDetails customerDetails =customer.getCustomerDetails();
//		System.out.println(customerDetails);
		
		 CustomerDetails customerDetails =session.get(CustomerDetails.class, 501);
		 Customer customer = customerDetails.getCustomer();
		 System.out.println(customerDetails);
		 System.out.println(customer);
		 
		 
		transaction.commit();
		
	} finally {
//			Closing Resources
		
		session.close();
		sessionFactory.close();
		
	}
	
	
	
}


	}


