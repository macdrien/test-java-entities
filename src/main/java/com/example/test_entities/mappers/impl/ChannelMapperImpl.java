package com.example.test_entities.mappers.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.test_entities.dtos.channel.CreateChannelDto;
import com.example.test_entities.dtos.channel.FullChannelDto;
import com.example.test_entities.dtos.channel.ShortChannelDto;
import com.example.test_entities.entities.Channel;
import com.example.test_entities.mappers.ChannelMapper;
import com.example.test_entities.mappers.PersonMapper;
import com.example.test_entities.repositories.PersonRepository;

@Component
public class ChannelMapperImpl implements ChannelMapper {

    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public ChannelMapperImpl(@Lazy PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }
    
    public FullChannelDto channelToFullChannelDto(Channel channel) {
        FullChannelDto fullDto = new FullChannelDto();

        fullDto.setId(channel.getId());
        fullDto.setName(channel.getName());
        fullDto.setCreator(personMapper.personToShortPersonDto(channel.getCreator()));

        return fullDto;
    }
    
    public ShortChannelDto channelToShortChannelDto(Channel channel) {
        ShortChannelDto shortDto = new ShortChannelDto();

        shortDto.setId(channel.getId());
        shortDto.setName(channel.getName());
        shortDto.setCreator(personMapper.personToShortPersonDto(channel.getCreator()));

        return shortDto;
    }

    public Channel createChannelDtoToChannel(CreateChannelDto createChannelDto) {
        Channel channel = new Channel();
        channel.setName(createChannelDto.getName());
        channel.setCreator(personRepository.findById(createChannelDto.getCreatorId()).orElse(null));
        return channel;
    }
}
