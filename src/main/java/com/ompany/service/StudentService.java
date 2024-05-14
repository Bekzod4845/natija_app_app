package com.ompany.service;


import com.ompany.dto.student.StudentCreateDTO;
import com.ompany.dto.student.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(int channelId, StudentCreateDTO studentCreateDTO);

    void deleteStudentId(int channelId,int studentId);

    List<StudentDTO> getList(String channelTgId);

    StudentDTO getStudent(int channelId,int studentId);
}
