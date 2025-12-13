package com.andyn4674.SpringSecurityWithDatabase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andyn4674.SpringSecurityWithDatabase.model.Person;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PersonController {
    
    private List<Person> people = new ArrayList<>(List.of(
        new Person(1, "A", 4),
        new Person(2, "B", 24)
    )); 

    @GetMapping("/people")
    public List<Person> getPeople()
    {
        return people;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person)
    {
        people.add(person);
        return person;
    }
}
