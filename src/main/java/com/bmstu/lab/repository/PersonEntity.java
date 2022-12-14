package com.bmstu.lab.repository;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String work;

    @Column(unique = true)
    private String name;
    private Integer age;

    public PersonEntity() {
    }

    public PersonEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonEntity(Long id, String name, Integer age, String work, String address) {
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

}
