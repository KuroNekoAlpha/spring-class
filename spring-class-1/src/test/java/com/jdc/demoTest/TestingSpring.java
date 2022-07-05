package com.jdc.demoTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.demo.HelloBean;

public class TestingSpring {
	
	@Test
	void test() {
		try(var context=new GenericXmlApplicationContext("classpath:/application.xml")){
		 var bean= context.getBean("hello", HelloBean.class);
		 var message=bean.getMessage();
			System.out.println(message);
		}
	}

}
