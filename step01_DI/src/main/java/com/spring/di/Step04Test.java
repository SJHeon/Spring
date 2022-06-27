package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.di.config.Step04Config;

import step03.model.domain.Car;
import step03.model.domain.People;

public class Step04Test {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(Step04Config.class);

		// step01
		// People
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);

		Car c1 = context.getBean("car", Car.class);
		System.out.println(c1);

	}

}
