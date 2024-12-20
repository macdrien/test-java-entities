package com.example.test_entities.dtos.channel;

import com.example.test_entities.dtos.person.ShortPersonDto;

public class ShortChannelDto {
    private Long id;
    private String name;
    private ShortPersonDto creator;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ShortPersonDto getCreator() {
        return creator;
    }
    public void setCreator(ShortPersonDto creator) {
        this.creator = creator;
    }

}
