package com.bmstu.lab;

import com.bmstu.lab.controller.Person;
import com.bmstu.lab.controller.PersonController;
import com.bmstu.lab.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class PersonControllerTest {
    @Test
    public void getTest(){
        PersonRepository personRepository = new PersonRepositoryMock();
        Person person = new Person(1L,"zaidhamasha",25,"progressoft","Moscow");
        ResponseEntity<?> responseEntity = new PersonController(personRepository).create(person, UriComponentsBuilder.newInstance());
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }
}
