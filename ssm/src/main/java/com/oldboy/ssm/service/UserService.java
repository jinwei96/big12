package com.oldboy.ssm.service;

import com.oldboy.ssm.domain.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);

    public void delete(Integer id) ;

    public User findById(Integer id) ;

    public List<User> findAll();

    public void update(User user);
}
