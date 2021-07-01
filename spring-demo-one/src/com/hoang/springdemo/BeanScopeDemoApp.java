package com.hoang.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// tai tep cau hinh Spring
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// lay bean tu thung chua container
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		// kiem tra 2 cai bean co giong nhau khong
		boolean result = (theCoach == alphaCoach);
		
		// hien thi ket qua
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);
		
		System.out.println("\nMemory location for theCoach: " + alphaCoach + "\n");
		
		// thoat context
		context.close();
	}
}
