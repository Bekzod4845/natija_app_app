package com.ompany.service;


import com.ompany.dto.answer.AnswerCreateDTO;
import com.ompany.dto.answer.AnswerDTO;
import com.ompany.dto.answer.AnswerResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AnswerService {
    AnswerDTO createAnswer(int studentId,AnswerCreateDTO answerCreateDTO);

    void deleteAnswerId(int studentId);

    List<AnswerResponseDTO> getList(int channelId);

    AnswerDTO getAnswer(int studentId);
}
