package com.example.test_entities.dtos.person;

import java.util.Set;

import com.example.test_entities.dtos.channel.ShortChannelDto;

public class FullPersonDto {
    private Long id;
    private String username;
    private Set<ShortChannelDto> channels;

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
    public Set<ShortChannelDto> getChannels() {
        return channels;
    }
    public void setChannels(Set<ShortChannelDto> channels) {
        this.channels = channels;
    }    
}
