package com.oldboy.mybatis;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private List<Order> orders = new ArrayList<Order>() ;
    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }

    private List<Order> list = new ArrayList<Order>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
