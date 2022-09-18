package com.bmstu.lab.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Person {

    private final Long id;
    private String work;
    private String address;

    @NotEmpty
    private String name;


    @Min(1)
    private final Integer age;

    public Person(Long id, @NotEmpty String name, @Min(1) Integer age, String work, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getWork() {
        return work;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public void setName(String name) {
        this.name= name;
    }
}
