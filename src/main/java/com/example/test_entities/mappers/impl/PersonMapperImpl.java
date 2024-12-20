package com.example.test_entities.mappers.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.test_entities.dtos.channel.ShortChannelDto;
import com.example.test_entities.dtos.person.CreatePersonDto;
import com.example.test_entities.dtos.person.FullPersonDto;
import com.example.test_entities.dtos.person.ShortPersonDto;
import com.example.test_entities.entities.Person;
import com.example.test_entities.mappers.ChannelMapper;
import com.example.test_entities.mappers.PersonMapper;

@Component
public class PersonMapperImpl implements PersonMapper {

    private ChannelMapper channelMapper;

    public PersonMapperImpl(ChannelMapper channelMapper) {
        this.channelMapper = channelMapper;
    }
    
    public FullPersonDto personToFullPersonDto(Person person) {
        FullPersonDto fullDto = new FullPersonDto();
        fullDto.setId(person.getId());
        fullDto.setUsername(person.getUsername());

        Set<ShortChannelDto> channelDtos = person.getChannels()
                                                .stream()
                                                .map(channelMapper::channelToShortChannelDto)
                                                .collect(Collectors.toSet());
        fullDto.setChannels(channelDtos);

        return fullDto;
    }

    public ShortPersonDto personToShortPersonDto(Person person) {
        ShortPersonDto shortDto = new ShortPersonDto();

        shortDto.setId(person.getId());
        shortDto.setUsername(person.getUsername());

        return shortDto;
    }

    public Person createPersonDtoToPerson(CreatePersonDto createPersonDto) {
        Person person = new Person();
        person.setUsername(createPersonDto.getUsername());
        person.setChannels(Set.of());
        return person;
    }
}
