package com.nbs.student.controller;


import com.nbs.student.model.StudentDto;
import com.nbs.student.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getStudent() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") int studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto) {
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.CREATED);
    }
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") int studentId, @RequestBody @Valid StudentDto student) {
        return new ResponseEntity<>(studentService.updateStudent(studentId,student), HttpStatus.OK);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
