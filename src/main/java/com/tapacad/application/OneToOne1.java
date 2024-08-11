package com.tapacad.application;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne1 {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//          Create Session Factory
			sessionFactory =  new Configuration().
					          configure().addAnnotatedClass(Customer.class).
					          addAnnotatedClass(CustomerDetails.class).
					          buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//				CRUD Operation
		     Customer c1 =  new Customer(1,"Alex");
		     CustomerDetails cd1 =new CustomerDetails(501,"alex@gmail.com","9142241549","Banglore");
		     c1.setCustomerDetails(cd1);
		     Serializable i =session.save(c1);
		     System.out.println(i);
		    
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	

	}


