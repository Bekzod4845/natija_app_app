package com.ompany.service.impl;



import com.ompany.dto.answer.AnswerCreateDTO;
import com.ompany.dto.answer.AnswerDTO;
import com.ompany.dto.answer.AnswerResponseDTO;
import com.ompany.dto.channel.ChannelCreateDTO;
import com.ompany.exceptions.StudentNotFoundException;
import com.ompany.models.Answer;
import com.ompany.models.AnswerResponse;
import com.ompany.models.Channel;
import com.ompany.models.Student;
import com.ompany.repository.AnswerRepository;
import com.ompany.repository.StudentRepository;
import com.ompany.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public AnswerDTO createAnswer(int studentId, AnswerCreateDTO answerCreateDTO) {
            Answer answer =  mapToEntity(answerCreateDTO);
            Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("not fount Student"));
            answer.setStudent(student);
            Answer newAnswer = answerRepository.save(answer);
            return new AnswerDTO(newAnswer.getId(),  newAnswer.getRed(), newAnswer.getGreen(), newAnswer.getPink(), newAnswer.getCreatedDate());
    }

    private Answer mapToEntity(AnswerCreateDTO answerCreateDTO) {
        Answer answer = new Answer();
        answer.setRed(answerCreateDTO.getRed());
        answer.setGreen(answerCreateDTO.getGreen());
        answer.setPink(answerCreateDTO.getPink());
        answer.setCreatedDate(LocalDate.now());

        return answer;
    }

    @Override
    public void deleteAnswerId(int studentId) {

    }

    @Override
    public List<AnswerResponseDTO> getList(int channelId) {
        List<AnswerResponse> answerList = answerRepository.findAllAnswer(channelId);
        Integer coutRed = answerRepository.findBy(channelId);
        return answerList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private AnswerResponseDTO mapToDto(AnswerResponse answerResponse) {
        return new AnswerResponseDTO(answerResponse.getLastName(), answerResponse.getStudentOriginalId(), answerResponse.getRed(), answerResponse.getGreen(), answerResponse.getPink(),answerResponse.getCreatedDate());
    }

    @Override
    public AnswerDTO getAnswer(int studentId) {
        return null;
    }
}

