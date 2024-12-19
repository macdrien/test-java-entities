package com.example.test_entities.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test_entities.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Set<Person> findAll();
}