package com.oldboy.spring.aop.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        WelcomeService ws = (WelcomeService) ac.getBean("welcomeService");
        ws.sayHello("tomas");
    }
    
}
