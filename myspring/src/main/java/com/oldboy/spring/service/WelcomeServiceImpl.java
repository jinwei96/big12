package com.oldboy.spring.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("welcomeService")
@Scope(value = "singleton")
public class WelcomeServiceImpl implements WelcomeService {
    private String name;
    @Resource(name="byeService")
    private ByeService bs;

    public ByeService getBs() {
        return bs;
    }

    public void setBs(ByeService bs) {
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        bs.sayBye();
    }
}
