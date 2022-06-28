package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.User;

public class loginTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("login.xml");

		User user = context.getBean("user", User.class);

		try {
			user.login("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
