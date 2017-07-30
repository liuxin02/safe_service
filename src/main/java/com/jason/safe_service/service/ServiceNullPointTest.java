package com.jason.safe_service.service;

import org.springframework.stereotype.Service;

import com.jason.safe_service.annotation.NullCreate;
import com.jason.safe_service.annotation.NullRefuse;
import com.jason.safe_service.annotation.SafeMethod;
import com.jason.safe_service.model.Task;



@Service
public class ServiceNullPointTest {
	
	@SafeMethod
	public void testAopCreate(String nice,Integer count, @NullCreate Task task,String... stringArray) {

		System.out.println(task.getPrice());
	}
	
	@SafeMethod
	public void testAopRefuse(String nice,Integer count, @NullRefuse Task task,String... stringArray) {
		
		System.out.println(task.getPrice());
	}
}
