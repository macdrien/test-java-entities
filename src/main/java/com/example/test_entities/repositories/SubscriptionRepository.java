package com.example.test_entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.test_entities.entities.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    // Empty body
}
