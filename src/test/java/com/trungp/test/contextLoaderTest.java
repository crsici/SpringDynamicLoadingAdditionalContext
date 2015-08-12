package com.trungp.test;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class contextLoaderTest {
	@Test
	public void test() throws IOException{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/root-context.xml");
		Hawaii hawaii =  (Hawaii)ctx.getBean("hawaii");
		System.out.println("===================================================================");
		hawaii.hello();
		System.out.println("===================================================================");
	}
}
