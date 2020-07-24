package com.example.test.service;

import com.example.test.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name);
    int count(String name);
    void add(String name,String password);
    void delete(String name);
    void modify(String name ,String password);

}
