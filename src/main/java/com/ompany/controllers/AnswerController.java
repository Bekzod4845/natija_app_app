package com.ompany.controllers;



import com.ompany.dto.answer.AnswerCreateDTO;
import com.ompany.dto.answer.AnswerDTO;
import com.ompany.dto.answer.AnswerResponseDTO;
import com.ompany.dto.channel.ChannelCreateDTO;
import com.ompany.dto.channel.ChannelDTO;
import com.ompany.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }


    @PostMapping("answer/{studentId}/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnswerDTO> createAnswer(@PathVariable(value = "studentId") int studentId, @RequestBody AnswerCreateDTO answerCreateDTO){
        return new ResponseEntity<>(answerService.createAnswer(studentId,answerCreateDTO),HttpStatus.CREATED);
    }


    @GetMapping("list/channel/{id}/answer")
    public ResponseEntity<List<AnswerResponseDTO>> getList(@PathVariable(value = "id") int channelId) {
        List<AnswerResponseDTO> list = answerService.getList(channelId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
