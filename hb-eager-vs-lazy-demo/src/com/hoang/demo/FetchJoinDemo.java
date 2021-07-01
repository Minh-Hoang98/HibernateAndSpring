package com.hoang.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hoang.demo.entity.Course;
import com.hoang.demo.entity.Instructor;
import com.hoang.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL

			int theId = 5;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i " 
									+ "JOIN FETCH i.courses " 
									+ "where i.id=:theInstructorId", Instructor.class); 
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("hoang: Instructor: "+ tempInstructor);
			
						
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("hoang: The session is closed!!!");
			
			// option 1: call getter method while session is open
			
			// print the associated instructor
						System.out.println("hoang: Course: " + 
												tempInstructor.getCourse());

			System.out.println("hoang: Done!");
		} finally {
			factory.close();
		}
	}

}
