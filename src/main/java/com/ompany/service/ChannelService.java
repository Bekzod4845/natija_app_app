package com.ompany.service;


import com.ompany.dto.channel.ChannelCreateDTO;
import com.ompany.dto.channel.ChannelDTO;

import java.util.List;

public interface ChannelService {
    ChannelDTO createChannel(int teacherId, ChannelCreateDTO channelCreateDTO);

    void deleteChannelId(int teacherId,int channelId);

    List<ChannelDTO> getList(String tgId);

    ChannelDTO getChannel(int teacherId, int channelId);
}
