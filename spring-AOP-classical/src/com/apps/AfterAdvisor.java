package com.apps;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvisor implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("Some stuff post method call(afterAdvise). Method name: "+arg1.getName());
	}

}
