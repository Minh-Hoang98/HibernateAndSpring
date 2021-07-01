package com.hoang.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hoang.demo.entity.Course;
import com.hoang.demo.entity.Instructor;
import com.hoang.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int theId = 5;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			// print the instructor detail
			System.out.println("Instructor: "+ tempInstructor);
			
			// print the associated instructor
			System.out.println("Course: " + 
									tempInstructor.getCourse());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
