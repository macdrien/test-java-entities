package com.example.test_entities.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_entities.dtos.person.CreatePersonDto;
import com.example.test_entities.dtos.person.FullPersonDto;
import com.example.test_entities.dtos.person.ShortPersonDto;
import com.example.test_entities.entities.Person;
import com.example.test_entities.mappers.PersonMapper;
import com.example.test_entities.repositories.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository repository;
    private PersonMapper personMapper;

    public PersonController(PersonRepository repository, PersonMapper personMapper) {
        this.repository = repository;
        this.personMapper = personMapper;
    }

    @GetMapping
    public Set<ShortPersonDto> findList() {
        Set<ShortPersonDto> people = new HashSet<>();
        repository.findAll().forEach(person -> {
            people.add(personMapper.personToShortPersonDto(person));
        });
        return people;
    }
    
    @GetMapping("/{id}")
    public FullPersonDto findById(@PathVariable("id") Long id) {
        Person person = repository.findById(id).orElse(null);

        if (person == null) {
            return null;
        }

        return personMapper.personToFullPersonDto(person);
    }

    @PostMapping
    public FullPersonDto creatPerson(@RequestBody CreatePersonDto createPersonDto) {
        Person person = personMapper.createPersonDtoToPerson(createPersonDto);
        repository.save(person);
        return personMapper.personToFullPersonDto(person);
    }
}
