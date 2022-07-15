/**
 * 
 */
package com.jdc.assignment.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdc.assignment.model.Course;
import com.jdc.assignment.model.CourseInsert;

/**
 * @author OAK SOE KHANT
 *
 */
public class HelloTest {

	
	private static ClassPathXmlApplicationContext IOC_CONTAINER;
	
	@BeforeAll
	static void start() {
		IOC_CONTAINER=new ClassPathXmlApplicationContext("classpath:/app_config.xml");
		
	}
	@AfterAll
	static void end() {
		IOC_CONTAINER.close();
	}

	@Test
	void test() {
		var c=new Course();
		c.setName("FULL STACK JAVA");
		c.setFee(250000);
		c.setDuration(6);
		
		var insert=IOC_CONTAINER.getBean("insert",CourseInsert.class);
		insert.insert(c);
	}
	

}
