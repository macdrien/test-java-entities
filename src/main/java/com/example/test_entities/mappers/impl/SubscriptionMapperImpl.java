package com.example.test_entities.mappers.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.test_entities.dtos.subscription.CreateSubscriptionDto;
import com.example.test_entities.dtos.subscription.FullSubscriptionDto;
import com.example.test_entities.dtos.subscription.ShortSubscriptionDto;
import com.example.test_entities.entities.Subscription;
import com.example.test_entities.mappers.PersonMapper;
import com.example.test_entities.mappers.SubscriptionMapper;
import com.example.test_entities.repositories.PersonRepository;

@Component
public class SubscriptionMapperImpl implements SubscriptionMapper {

    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public SubscriptionMapperImpl(@Lazy PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public FullSubscriptionDto subscriptionToFullSubscriptionDto(Subscription subscription) {
        FullSubscriptionDto fullSubscriptionDto = new FullSubscriptionDto();
        fullSubscriptionDto.setId(subscription.getId());
        fullSubscriptionDto.setPerson(personMapper.personToShortPersonDto(subscription.getPerson()));
        return fullSubscriptionDto;
    }

    public ShortSubscriptionDto subscriptionToShortSubscriptionDto(Subscription subscription) {
        ShortSubscriptionDto shortSubscriptionDto = new ShortSubscriptionDto();
        shortSubscriptionDto.setId(subscription.getId());
        return shortSubscriptionDto;
    }

    public Subscription createSubcriptionDtoToSubscription(CreateSubscriptionDto createSubscriptionDto) {   
        Subscription subscription = new Subscription();
        subscription.setId(null);
        subscription.setPerson(personRepository.findById(createSubscriptionDto.getPersonId()).orElse(null));
        return subscription;
    }
    
}
