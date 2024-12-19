package com.example.test_entities.dtos;

import java.util.Set;

import com.example.test_entities.entities.Channel;

public class PersonDto {
    private Long id;
    private String username;
    private Set<Channel> channels;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Set<Channel> getChannels() {
        return channels;
    }
    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }    
}
