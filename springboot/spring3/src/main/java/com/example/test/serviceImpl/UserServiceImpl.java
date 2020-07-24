package com.example.test.serviceImpl;

import com.example.test.bean.*;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component()
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name) {

        return userMapper.getInfo(name);
    }
    @Override
    public int count(String name){
        return userMapper.count(name);
    }

    @Override
    public void add(String name,String password){
        //String name = userBean == null ? "":userBean.getName();
        //UserBean bean = userMapper.getInfo(name);
        userMapper.add(name,password);
    }
    @Override
    public void delete(String name){userMapper.delete(name);}
    @Override
    public void modify(String name,String password){userMapper.modify(name,password);}
}
