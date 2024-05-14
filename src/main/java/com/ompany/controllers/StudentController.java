package com.ompany.controllers;



import com.ompany.dto.student.StudentCreateDTO;
import com.ompany.dto.student.StudentDTO;
import com.ompany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class StudentController {

   @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("channel/{channelId}/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDTO> createStudent(@PathVariable(value = "channelId") int channelId, @RequestBody StudentCreateDTO studentCreateDTO){
        return new ResponseEntity<>(studentService.createStudent(channelId,studentCreateDTO),HttpStatus.CREATED);
    }

    @GetMapping("list/student/channel/{tgId}")
    public ResponseEntity<List<StudentDTO>> getList(@PathVariable(value = "tgId") String tgId) {
        List<StudentDTO> list = studentService.getList(tgId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("get/channel/{ch_id}/student/{id}")
    public ResponseEntity<StudentDTO> studentDetail(@PathVariable int ch_id, @PathVariable int id){
        return ResponseEntity.ok(studentService.getStudent(ch_id,id));
    }

    @DeleteMapping("delete/channel/{ch_id}/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int ch_id, @PathVariable int id) {
        studentService.deleteStudentId(ch_id,id);
        return new ResponseEntity<>("student delete", HttpStatus.OK);
    }
}
