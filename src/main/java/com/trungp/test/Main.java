package com.trungp.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws IOException{
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/root-context.xml");
		
		Hawaii hawaii =  (Hawaii)ctx.getBean("hawaii");
		System.out.println("===================================================================");
		hawaii.hello();
		System.out.println("===================================================================");
	}
}
