package com.example.test_entities.mappers;

import com.example.test_entities.dtos.channel.CreateChannelDto;
import com.example.test_entities.dtos.channel.FullChannelDto;
import com.example.test_entities.dtos.channel.ShortChannelDto;
import com.example.test_entities.entities.Channel;

public interface ChannelMapper {
    public FullChannelDto channelToFullChannelDto(Channel channel);
    public ShortChannelDto channelToShortChannelDto(Channel channel);
    public Channel createChannelDtoToChannel(CreateChannelDto createChannelDto);
}
