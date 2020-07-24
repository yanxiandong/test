package com.kuanquan.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/selectPerson",method = RequestMethod.GET)
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(String.valueOf(1));
        Person person = personService.findPersonById(personId);

        String s = JSON.toJSONString(person);
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(s);
        response.getWriter().close();
    }


    @RequestMapping(value = "/selectPersonName",method = RequestMethod.GET)
    public void selectPersonName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        String person = personService.findPersonName(personId);

//        String s = JSON.toJSONString(person);
//        System.out.println(s);
//        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(person);
        response.getWriter().close();
    }
}