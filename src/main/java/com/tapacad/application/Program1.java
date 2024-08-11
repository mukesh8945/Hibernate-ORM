package com.tapacad.application;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tapacad.model.Student;

public class Program1 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

//			Create Session Factory

//				Configuration config = new Configuration();
//				config.configure();
//				config.addAnnotatedClass(Student.class);
//				SessionFactory sessionFactory = config.buildSessionFactory();

//				Second methods  Create Session Factory
			sessionFactory =  new Configuration().
					          configure().addAnnotatedClass(Student.class).
					          buildSessionFactory();

//				Create Session
			session = sessionFactory.openSession();

//				Create Transaction
			Transaction transaction = session.beginTransaction();

//				CRUD Operation

			Student s1 = new Student(6, "zikair", "zakarir@gmail.com",78);
			Serializable id = session.save(s1);
			System.out.println(id);

			transaction.commit();

		} finally {
//			Closing Resources

			session.close();
			sessionFactory.close();

		}



	}

}
