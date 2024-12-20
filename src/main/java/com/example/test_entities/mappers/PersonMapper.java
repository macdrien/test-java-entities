package com.example.test_entities.mappers;

import com.example.test_entities.dtos.person.CreatePersonDto;
import com.example.test_entities.dtos.person.FullPersonDto;
import com.example.test_entities.dtos.person.ShortPersonDto;
import com.example.test_entities.entities.Person;

public interface PersonMapper {
    public FullPersonDto personToFullPersonDto(Person person);
    public ShortPersonDto personToShortPersonDto(Person person);
    public Person createPersonDtoToPerson(CreatePersonDto createPersonDto);
}
