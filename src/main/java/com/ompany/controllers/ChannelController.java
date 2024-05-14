package com.ompany.controllers;



import com.ompany.dto.channel.ChannelCreateDTO;
import com.ompany.dto.channel.ChannelDTO;
import com.ompany.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ChannelController {

   @Autowired
    private ChannelService channelService;
   
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("channel/{teacherId}/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ChannelDTO> createChannel(@PathVariable(value = "teacherId") int teacherId, @RequestBody ChannelCreateDTO channelCreateDTO){
        return new ResponseEntity<>(channelService.createChannel(teacherId,channelCreateDTO),HttpStatus.CREATED);
    }

    @GetMapping("list/channel/teacher/{tgId}")
    public ResponseEntity<List<ChannelDTO>> getList(@PathVariable(value = "tgId") String tgId) {
        List<ChannelDTO> list = channelService.getList(tgId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("get/teacher/{teacherId}/channel/{channelId}")
    public ResponseEntity<ChannelDTO> channelDetail(@PathVariable int teacherId, @PathVariable int channelId){
        return ResponseEntity.ok(channelService.getChannel(teacherId,channelId));
    }

    @DeleteMapping("delete/teacher/{teacherId}/channel/{channelId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int teacherId, @PathVariable int channelId) {
        channelService.deleteChannelId(teacherId,channelId);
        return new ResponseEntity<>("channel delete", HttpStatus.OK);
    }
}
