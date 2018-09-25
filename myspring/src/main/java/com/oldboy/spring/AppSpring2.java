package com.oldboy.spring;

import com.oldboy.spring.service.WelcomeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpring2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans2.xml");
        WelcomeService ws = (WelcomeService) ac.getBean("welcomeService");
        ws.sayHello();
    }



}
