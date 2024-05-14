package com.ompany.service;


import com.ompany.dto.teacher.TeacherCreateDTO;
import com.ompany.dto.teacher.TeacherDTO;

import java.util.List;

public interface TeacherService {

    TeacherDTO createTeacher(TeacherCreateDTO teacherCreateDTO);

    List<TeacherDTO> getListTeacher();

    TeacherDTO getTeacherById(int id);

    void  deleteTeacherId(int id);



}
