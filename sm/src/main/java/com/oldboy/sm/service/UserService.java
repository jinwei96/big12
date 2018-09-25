package com.oldboy.sm.service;

import com.oldboy.sm.domain.User;

public interface UserService {
    public void insertUser(User user);

    public void delete(Integer id) ;
}
