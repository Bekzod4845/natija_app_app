package com.ompany.service.impl;



import com.ompany.dto.channel.ChannelCreateDTO;
import com.ompany.dto.channel.ChannelDTO;
import com.ompany.exceptions.ChannelNotFoundException;
import com.ompany.exceptions.TeacherNotFoundException;
import com.ompany.models.Channel;
import com.ompany.models.Teacher;
import com.ompany.repository.ChannelRepository;
import com.ompany.repository.TeacherRepository;
import com.ompany.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository, TeacherRepository teacherRepository) {
        this.channelRepository = channelRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public ChannelDTO createChannel(int teacherId, ChannelCreateDTO channelCreateDTO) {
        Channel channel = mapToEntity(channelCreateDTO);
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new TeacherNotFoundException("Teacher with associated channel not found"));
        channel.setTeacher(teacher);
        Channel newChannel = channelRepository.save(channel);
        return mapToDto(newChannel);
    }



    @Override
    public void deleteChannelId(int teacherId, int channelId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException("Teacher with associated channel not found"));;

        Channel channel = channelRepository.findById(channelId).orElseThrow(()->new ChannelNotFoundException("Channel with associated teacher not found"));

        if (channel.getTeacher().getId() != teacher.getId()){
            throw  new ChannelNotFoundException("This channel does not belong to a teacher");
        }

        channelRepository.delete(channel);
    }

    @Override
    public List<ChannelDTO> getList(String teacherTgId) {
        List<Channel> channels = channelRepository.findAllByTeacherTgId(teacherTgId);
        return channels.stream().map(channel -> mapToDto(channel)).collect(Collectors.toList());
    }

    @Override
    public ChannelDTO getChannel(int teacherId, int channelId) {


        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException("Teacher with associated channel not found"));;

        Channel channel = channelRepository.findById(channelId).orElseThrow(()->new ChannelNotFoundException("Channel with associated teacher not found"));

        if (channel.getTeacher().getId() != teacher.getId()){
            throw  new ChannelNotFoundException("This channel does not belong to a teacher");
        }

        return mapToDto(channel);
    }




    private ChannelDTO mapToDto(Channel channel) {
        return new ChannelDTO(channel.getId(), channel.getName(), channel.getTgId(), channel.getCreatedDate());
    }

    private Channel mapToEntity(ChannelCreateDTO channelCreateDTO) {
        return new Channel(channelCreateDTO.getName(), channelCreateDTO.getTgId());
    }
}

