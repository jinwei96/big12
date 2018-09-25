package com.oldboy.sm.test;

import com.oldboy.sm.domain.User;
import com.oldboy.sm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {
    @Test
    public void testInsert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService user = (UserService) ac.getBean("userService");
        User u = new User();
        u.setName("zhang");
        u.setAge(20);
        user.insertUser(u);
    }

}
