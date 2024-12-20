package com.example.test_entities.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_entities.dtos.channel.CreateChannelDto;
import com.example.test_entities.dtos.channel.FullChannelDto;
import com.example.test_entities.dtos.channel.ShortChannelDto;
import com.example.test_entities.entities.Channel;
import com.example.test_entities.mappers.ChannelMapper;
import com.example.test_entities.repositories.ChannelRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private ChannelRepository repository;
    private ChannelMapper channelMapper;

    public ChannelController(ChannelRepository repository, ChannelMapper channelMapper) {
        this.repository = repository;
        this.channelMapper = channelMapper;
    }

    @GetMapping
    public Set<ShortChannelDto> findList() {
        Set<ShortChannelDto> channels = new HashSet<>();
        repository.findAll().forEach(channel -> channels.add(channelMapper.channelToShortChannelDto(channel)));
        return channels;
    }
    
    @GetMapping("/{id}")
    public FullChannelDto findById(@PathVariable("id") Long id) {
        Channel channel = repository.findById(id).orElse(null);

        if (channel == null) {
            return null;
        }

        return channelMapper.channelToFullChannelDto(channel);
    }

    @PostMapping
    public FullChannelDto createChannel(@RequestBody CreateChannelDto createChannelDto) {
        Channel channel = channelMapper.createChannelDtoToChannel(createChannelDto);
        repository.save(channel);
        return channelMapper.channelToFullChannelDto(channel);
    }
}
