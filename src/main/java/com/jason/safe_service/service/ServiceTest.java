package com.jason.safe_service.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ServiceTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceNullPointTest bean = context.getBean(ServiceNullPointTest.class);
		bean.testAopCreate("nice", 5, null);
		
	}
}
