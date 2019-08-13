package com.spring.blog.blog.domain;

public class User {
    private Long id;
    private String name;
    private String email;

    //生成构造函数包含带参数和不带参数的
    public User(){

    }
    public  User(Long id,String name,String email){

        this.email = email;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
