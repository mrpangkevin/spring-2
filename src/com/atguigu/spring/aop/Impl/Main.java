package com.atguigu.spring.aop.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		int result = arithmeticCalculator.add(3,3);
		System.out.println("result:"+result);
		result = arithmeticCalculator.div(6,3);
		System.out.println("result:"+result);
	}
}
