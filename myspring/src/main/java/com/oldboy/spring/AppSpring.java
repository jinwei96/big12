package com.oldboy.spring;

import com.oldboy.spring.service.WelcomeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        WelcomeService ws = (WelcomeService) ac.getBean("welcomeService");
        ws.sayHello();
    }
    
}
