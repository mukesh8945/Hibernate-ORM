package com.tapacad.model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//		    Create Session Factory
			sessionFactory =  new Configuration().
					          configure().addAnnotatedClass(Employee.class).
					          addAnnotatedClass(Project.class).
					          buildSessionFactory();
			
//				Create Session
			session = sessionFactory.openSession();
			
//				Create Transaction
			Transaction transaction = session.beginTransaction();
			
//			CRUD Operation
			
//			Creating Employee
			
			  Employee alex =new Employee(1,"Alex","alex@gmail.com");
			  Employee charli =new Employee(2,"Charli","charli@gmail.com");
			  Employee bob =new Employee(3,"Bob","bob@gmail.com");
			  
//			  Creating Projects
			  Project pr =new Project(1,"PremierPro");
			  Project af =new Project(2,"Aftereffects");
			  
			   ArrayList<Employee> premployees = new ArrayList<Employee>();
			   ArrayList<Employee> afemployees = new ArrayList<Employee>();
			   
//			   Assigning Employees to premier pro project
			   premployees.add(alex);
			   premployees.add(charli);
			   premployees.add(bob);
			   pr.setEmployees(premployees);
			   
			   
//			   Assigning Employees to after effects  project
			   afemployees.add(bob);
			   afemployees.add(charli);
			   af.setEmployees(afemployees);
			   
			   session.save(alex);
			   session.save(charli);
			   session.save(bob);
			   
			   session.save(pr);
			   session.save(af);
			   
			   
			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	

	}


