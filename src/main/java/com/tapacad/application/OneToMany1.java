package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Orders;

public class OneToMany1 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//		    Create Session Factory
			sessionFactory =  new Configuration().
					          configure().addAnnotatedClass(Customer.class).
					          addAnnotatedClass(CustomerDetails.class).
					          addAnnotatedClass(Orders.class).
					          buildSessionFactory();
			
//			 Create Session
			 session = sessionFactory.openSession();
			
//			 Create Transaction
			 Transaction transaction = session.beginTransaction();
			
//	         CRUD Operation
		     Customer customer = new Customer(3,"charli");
		     CustomerDetails customerDetails = new CustomerDetails(501,"alex@gmail.com","9142241549","Banglore");
		     customer.setCustomerDetails(customerDetails);
		
		
			
//			Create Orders
			
			Orders o1 =new Orders(201,"Bonda",500);
			Orders o2 =new Orders(202,"fishCurry",250);
			Orders o3 =new Orders(203,"Bonda",450);
			
			
//			Fetch Customer Object
			
//			Customer cust = session.get(Customer.class, 4);
		    
//		    Set Customer to Orders
		 
		    o1.setCustomer(customer);
		    o2.setCustomer(customer);
		    o3.setCustomer(customer);
		    
//		    Save To DataBase (Into Orders Table)
		    System.out.println(session.save(o1));
		    System.out.println(session.save(o2));
		    System.out.println(session.save(o3));
		    
		    
		    
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	

	}


