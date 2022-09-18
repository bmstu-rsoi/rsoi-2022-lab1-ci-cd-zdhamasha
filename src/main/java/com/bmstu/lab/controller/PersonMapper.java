package com.bmstu.lab.controller;

import com.bmstu.lab.repository.PersonEntity;

public class PersonMapper {

    public static PersonEntity toEntity(Person person){
        return new PersonEntity(person.getId(), person.getName(), person.getAge(), person.getWork(), person.getAddress());
    }

    public static PersonEntity toEntity(Person person, Long id){
        return new PersonEntity(id, person.getName(), person.getAge(), person.getWork(), person.getAddress());
    }

    public static Person fromEntity(PersonEntity entity){
        return new Person(entity.getId(), entity.getName(), entity.getAge(), entity.getWork(), entity.getAddress());
    }
}
