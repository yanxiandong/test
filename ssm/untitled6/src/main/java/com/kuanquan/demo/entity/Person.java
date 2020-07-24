package com.kuanquan.demo.entity;


/**
 * 数据库表中字段的映射
 * 类名一般都是用表明命名的，好区分
 */
public class Person {

    // 下面都是数据库表中每一列字段
    private int user_id;
    private String name;
    private int age;
    private int sex;
    private String create_time;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }



    @Override
    public String toString() {
        return "Person{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", create_time='" + create_time + '\'' +

                '}';
    }
}