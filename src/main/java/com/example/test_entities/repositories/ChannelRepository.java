package com.example.test_entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.test_entities.entities.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
    // Empty interface
}
