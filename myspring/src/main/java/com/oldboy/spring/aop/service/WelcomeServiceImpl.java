package com.oldboy.spring.aop.service;

public class WelcomeServiceImpl implements WelcomeService {
    public void sayHello(String name) {

        System.out.println("Hello :" + name);
    }
}
