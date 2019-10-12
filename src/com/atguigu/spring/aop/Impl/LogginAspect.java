package com.atguigu.spring.aop.Impl;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
@Component
public class LogginAspect {

	@Before("execution(public int com.atguigu.spring.aop.Impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method [" + methodname + "] begins with : " + args);
	}
}
