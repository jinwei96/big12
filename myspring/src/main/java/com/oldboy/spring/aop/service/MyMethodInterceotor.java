package com.oldboy.spring.aop.service;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceotor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("begin");
        Object o = invocation.proceed();
        System.out.println("end");
        return o;
    }
}
