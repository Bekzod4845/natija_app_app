package com.ompany.service.impl;


import com.ompany.dto.teacher.TeacherCreateDTO;
import com.ompany.dto.teacher.TeacherDTO;
import com.ompany.exceptions.TeacherNotFoundException;
import com.ompany.models.Teacher;
import com.ompany.repository.TeacherRepository;
import com.ompany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
 @Autowired
  private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO createTeacher(TeacherCreateDTO teacherCreateDTO) {
        Teacher teacher = mapToEntity(teacherCreateDTO);
        Teacher newTeacher = teacherRepository.save(teacher);
        return mapToDto(newTeacher);
    }

    @Override
    public List<TeacherDTO> getListTeacher() {
        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherDTO>dtoList = new ArrayList<>();

        teacherList.forEach(teacher -> {
            TeacherDTO teacherDTO = mapToDto(teacher);
            dtoList.add(teacherDTO);
        });
        return dtoList;
    }

    @Override
    public TeacherDTO getTeacherById(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("Teacher could not be found"));
        return mapToDto(teacher);
    }

    @Override
    public void deleteTeacherId(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("Teacher could not be delete"));
        teacherRepository.delete(teacher);
    }

    private TeacherDTO mapToDto(Teacher teacher) {
        return new TeacherDTO(teacher.getId(), teacher.getName(),teacher.getTgId(),teacher.getCreatedDate());
    }

    private Teacher mapToEntity(TeacherCreateDTO teacherCreateDTO) {
        return new Teacher(teacherCreateDTO.getName(),teacherCreateDTO.getTgId());
    }
}
