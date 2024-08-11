package com.tapacad.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import com.tapacad.model.Employee;
import com.tapacad.model.Project;

public class ManyToManyFetchData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
//	       Create Session Factory
			sessionFactory =  new Configuration().
					          configure().addAnnotatedClass(Employee.class).
					          addAnnotatedClass(Project.class).
					          buildSessionFactory();
			
			
//			Create Session
			session = sessionFactory.openSession();
			
//			Create Transaction
			Transaction transaction = session.beginTransaction();
			
//			CRUD Operation
//			Employee employee=session.get(Employee.class, 5);
			Employee employee=session.load(Employee.class, 5);
			
//		    java.util.List<Project> projects =employee.getProjects();
		    System.out.println(employee);
		    
//		    for(Project project : projects) {
//		    	System.out.println(projects);
//		    }
			
//			Project project =session.get(Project.class, 1);
//		    java.util.List<Employee> employees = project.getEmployees();
//		   
//		    System.out.println(project);
//		   
//		   for(Employee employee :employees) {
//			   System.out.println(employee);
//			   
//		   }
		    

			transaction.commit();
			
		} finally {
//			Closing Resources
			
			session.close();
			sessionFactory.close();
			
		}
		
		
		
	}
	
	}


