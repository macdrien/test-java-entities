package com.example.test_entities.controllers;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_entities.dtos.PersonDto;
import com.example.test_entities.entities.Person;
import com.example.test_entities.repositories.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Set<PersonDto> findList() {
        return repository.findAll().stream().map(person -> {
            PersonDto dto = new PersonDto();
            dto.setId(person.getId());
            dto.setUsername(person.getUsername());
            return dto;
        }).collect(Collectors.toSet());
    }
    
    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Person creatPerson(@RequestBody Person person) {
        person.setId(null);
        repository.save(person);
        return person;
    }
}
