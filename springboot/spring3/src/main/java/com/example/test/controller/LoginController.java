package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.serviceImpl.Result;
import com.example.test.service.UserService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @Autowired
    Result<UserBean> result;
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<UserBean> login(String name,String password){
        UserBean userBean=userService.loginIn(name);
        if(userBean==null || userBean.getName().equals(password)){
            result.setCode(2);
            result.setMessage("用户或密码错误！");
            result.setData(null);

        }else{
            result.setCode(4);
            result.setMessage("Success!");
            result.setData(userBean);
        }
        return  result;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result<UserBean>  register(String name,String password){
        UserBean  userBean=userService.loginIn(name);
        System.out.println(userBean);
        if(userBean==null){
            userService.add(name,password);
            result.setCode(1);
            result.setMessage("注册成功！");
            //找出刚插入的数据
            UserBean  userBean1=userService.loginIn(name);
            result.setData(userBean1);

        }else{
            result.setCode(0);
            result.setMessage("用户名已注册");
            result.setData(null);

        }
        return result;
    }











    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Result<UserBean> login1(String name) {
        //int count=userService.count(name);

        try{
            UserBean userBean1 = userService.loginIn(name);
            if(userBean1==null)
                result.setCode(0);
            else
                result.setCode(1);

        }catch (org.apache.ibatis.exceptions.TooManyResultsException e){
            System.out.println(e.getLocalizedMessage());
            System.out.println();
            result.setCode(2);

        }
        catch (org.mybatis.spring.MyBatisSystemException e){

            System.out.println(" errors"+e);
            System.out.println(" errors"+ e.getCause());
            System.out.println(" errors"+ e.getMostSpecificCause());

            result.setCode(2);


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            result.modfiy();

            return result;
        }
        /*
        if(count==1){
        UserBean userBean = userService.loginIn(name);
        result.setCode(1);
        result.setData(userBean);


        }else{
            result.setCode(count);
        }
        result.modfiy();
        return  result;*/
    }
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(String name,String password){
        UserBean userBean1 = userService.loginIn(name);
        if(userBean1==null)
            userService.add(name,password);


    }
    //删
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(String name){

        UserBean userBean1 = userService.loginIn(name);
        if(userBean1!=null)
            userService.delete(name);

    }
    //改
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public void modify(String name,String password){

        UserBean userBean1 = userService.loginIn(name);
        if(userBean1!=null)
            userService.modify(name,password);


    }


}
