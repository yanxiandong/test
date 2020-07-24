package com.example.test.mapper;

import com.example.test.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name);
    int count(String name);
    void add(String name,String password);
    void delete(String name);
    void modify(String name,String password);

}
