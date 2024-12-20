package com.example.test_entities.dtos.subscription;

import com.example.test_entities.dtos.person.ShortPersonDto;

public class FullSubscriptionDto {
    private Long id;
    private ShortPersonDto person;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ShortPersonDto getPerson() {
        return person;
    }
    public void setPerson(ShortPersonDto person) {
        this.person = person;
    }
}
