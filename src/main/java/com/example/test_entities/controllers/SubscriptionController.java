package com.example.test_entities.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_entities.dtos.subscription.CreateSubscriptionDto;
import com.example.test_entities.dtos.subscription.FullSubscriptionDto;
import com.example.test_entities.dtos.subscription.ShortSubscriptionDto;
import com.example.test_entities.entities.Subscription;
import com.example.test_entities.mappers.SubscriptionMapper;
import com.example.test_entities.repositories.SubscriptionRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    
    private SubscriptionRepository repository;
    private SubscriptionMapper subscriptionMapper;

    public SubscriptionController(SubscriptionRepository repository, SubscriptionMapper subscriptionMapper) {
        this.repository = repository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @GetMapping
    public Set<ShortSubscriptionDto> findAll() {
        Set<ShortSubscriptionDto> subscriptions = new HashSet<>();
        repository.findAll().forEach(subscription ->
            subscriptions.add(subscriptionMapper.subscriptionToShortSubscriptionDto(subscription)));
        return subscriptions;
    }

    @GetMapping("/{id}")
    public FullSubscriptionDto findById(@PathVariable("id") Long id) {
        return subscriptionMapper.subscriptionToFullSubscriptionDto(repository.findById(id).orElse(null));
    }
    
    @PostMapping
    public FullSubscriptionDto subscribe(@RequestBody CreateSubscriptionDto createSubscriptionDto) {
        Subscription subscription = subscriptionMapper.createSubcriptionDtoToSubscription(createSubscriptionDto);
        repository.save(subscription);
        return subscriptionMapper.subscriptionToFullSubscriptionDto(subscription);
    }
    
}