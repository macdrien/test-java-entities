package com.example.test_entities.mappers;

import com.example.test_entities.dtos.subscription.CreateSubscriptionDto;
import com.example.test_entities.dtos.subscription.FullSubscriptionDto;
import com.example.test_entities.dtos.subscription.ShortSubscriptionDto;
import com.example.test_entities.entities.Subscription;

public interface SubscriptionMapper {
    public ShortSubscriptionDto subscriptionToShortSubscriptionDto(Subscription subscription);
    public FullSubscriptionDto subscriptionToFullSubscriptionDto(Subscription subscription);
    public Subscription createSubcriptionDtoToSubscription(CreateSubscriptionDto createSubscriptionDto);
}
