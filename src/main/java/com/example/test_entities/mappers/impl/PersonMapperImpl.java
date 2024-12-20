package com.example.test_entities.mappers.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.test_entities.dtos.channel.ShortChannelDto;
import com.example.test_entities.dtos.person.CreatePersonDto;
import com.example.test_entities.dtos.person.FullPersonDto;
import com.example.test_entities.dtos.person.ShortPersonDto;
import com.example.test_entities.dtos.subscription.ShortSubscriptionDto;
import com.example.test_entities.entities.Person;
import com.example.test_entities.mappers.ChannelMapper;
import com.example.test_entities.mappers.PersonMapper;
import com.example.test_entities.mappers.SubscriptionMapper;

@Component
public class PersonMapperImpl implements PersonMapper {

    private ChannelMapper channelMapper;
    private SubscriptionMapper subscriptionMapper;

    public PersonMapperImpl(ChannelMapper channelMapper, SubscriptionMapper subscriptionMapper) {
        this.channelMapper = channelMapper;
        this.subscriptionMapper = subscriptionMapper;
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

        Set<ShortSubscriptionDto> subscriptionDtos = person.getSubscriptions()
                                                        .stream()
                                                        .map(subscriptionMapper::subscriptionToShortSubscriptionDto)
                                                        .collect(Collectors.toSet());
        fullDto.setSubscriptions(subscriptionDtos);
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
        person.setSubscriptions(Set.of());
        return person;
    }
}
