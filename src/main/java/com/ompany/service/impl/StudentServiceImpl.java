package com.ompany.service.impl;




import com.ompany.dto.student.StudentCreateDTO;
import com.ompany.dto.student.StudentDTO;
import com.ompany.exceptions.ChannelNotFoundException;
import com.ompany.exceptions.TeacherNotFoundException;
import com.ompany.models.Channel;
import com.ompany.models.Student;
import com.ompany.models.Teacher;
import com.ompany.repository.ChannelRepository;
import com.ompany.repository.StudentRepository;
import com.ompany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(ChannelRepository channelRepository, StudentRepository studentRepository) {
        this.channelRepository = channelRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(int channelId, StudentCreateDTO studentCreateDTO) {
        Student student = mapToEntity(studentCreateDTO);
        Channel channel = channelRepository.findById(channelId).orElseThrow(()-> new ChannelNotFoundException("Channel with associated student not found"));
        student.setChannel(channel);
      Student newStudent = studentRepository.save(student);
        return mapToDto(newStudent);
    }




    @Override
    public void deleteStudentId(int channelId,int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new TeacherNotFoundException("Channel with associated student not found"));;
        Channel channel = channelRepository.findById(channelId).orElseThrow(()->new ChannelNotFoundException("Student with associated channel not found"));

        if (student.getChannel().getId() != channel.getId()){
            throw  new ChannelNotFoundException("This student does not belong to a channel");
        }
        studentRepository.delete(student);
    }

    @Override
    public List<StudentDTO> getList(String channelTgId) {
        List<Student> students = studentRepository.findAllByChannelTgId(channelTgId);
        return students.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudent(int channelId,int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new TeacherNotFoundException("Channel with associated student not found"));;
        Channel channel = channelRepository.findById(channelId).orElseThrow(()->new ChannelNotFoundException("Student with associated channel not found"));
        if ( student.getChannel().getId() != channel.getId()){
            throw  new ChannelNotFoundException("This student does not belong to a channel");
        }

        return mapToDto(student);
    }




    private StudentDTO mapToDto(Student student) {
        return new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),student.getOriginalId(), student.getCreatedDate());
    }
    private Student mapToEntity(StudentCreateDTO studentCreateDTO) {
        return new Student(studentCreateDTO.getFirstName(),studentCreateDTO.getLastName(),studentCreateDTO.getOriginalId());
    }

}

