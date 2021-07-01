package com.hoang.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hoang.demo.entity.Course;
import com.hoang.demo.entity.Instructor;
import com.hoang.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects

			/*
			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
			 * "darby@luv2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new InstructorDetail(
			 * "http://www.luv2code.com/youtube", "Luv 2 code!!!");
			 * 
			 */

			
			  Instructor tempInstructor = new Instructor("Susan", "Public",
			  "susan.public@luv2code.com");
			  
			  InstructorDetail tempInstructorDetail = new InstructorDetail(
			  "http://www.youtube.com", "Video Games");
			 

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
