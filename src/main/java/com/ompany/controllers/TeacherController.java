package com.ompany.controllers;


import com.ompany.dto.teacher.TeacherCreateDTO;
import com.ompany.dto.teacher.TeacherDTO;
import com.ompany.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("teacher/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherCreateDTO teacherCreateDTO){
        return new ResponseEntity<>(teacherService.createTeacher(teacherCreateDTO),HttpStatus.CREATED);
    }

    @GetMapping("get/teacher/{id}")
    public ResponseEntity<TeacherDTO> teacherDetail(@PathVariable int id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }



    @DeleteMapping("delete/teacher/{id}")
    public ResponseEntity<String> deleteTerritory(@PathVariable("id") int id) {
        teacherService.deleteTeacherId(id);
        return new ResponseEntity<>("teacher delete", HttpStatus.OK);
    }

    @GetMapping("list/teacher")
    public ResponseEntity<List<TeacherDTO>> getList() {
        List<TeacherDTO> list = teacherService.getListTeacher();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
