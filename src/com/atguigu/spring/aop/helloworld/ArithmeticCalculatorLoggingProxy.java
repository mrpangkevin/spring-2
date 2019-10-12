package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator t) {
		// TODO Auto-generated constructor stub
		target = t;
	}
	
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("invoke...");				
				String methodname = method.getName();
				System.out.println("The method "+methodname+ " begins with " + Arrays.asList(args));
				Object result =  method.invoke(target, args);
				System.out.println("The method "+methodname+ " ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator)Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), h);
		return proxy;
	}
}
