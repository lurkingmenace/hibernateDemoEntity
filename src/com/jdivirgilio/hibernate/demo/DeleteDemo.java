package com.jdivirgilio.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdivirgilio.hibernate.demo.entity.Instructor;
import com.jdivirgilio.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // Default name of file. Not
																					// necessary to include here.
																					// Must be in class path though!
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();


		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// Get the instructor by primary key
		Instructor instructor = session.get(Instructor.class, 1);

		// delete the instructor - will also delete the associated detail record
		if (instructor != null) {
			session.delete(instructor);
		}

		
		
		session.getTransaction().commit();
	
	}
}
