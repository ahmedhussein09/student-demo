package com.nbs.student.service;

import com.nbs.student.dao.entity.Student;
import com.nbs.student.dao.repository.StudentRepository;
import com.nbs.student.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentDto::new).toList();
    }
    public StudentDto getStudentById(int id) {
        return studentRepository.findById((long) id).map(StudentDto::new).orElse(null);
    }
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = studentRepository.save(new Student(studentDto));
        return new StudentDto(student);
    }
    public StudentDto updateStudent(int studentId, StudentDto studentDto) {
        Student student = studentRepository.findById((long) studentId).get();
        student.setAge(studentDto.getAge());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setGender(studentDto.getGender());
        student.setStatus(studentDto.isStatus());
        student = studentRepository.save(student);
        return new StudentDto(student);
    }
    public void deleteStudent(int id) {
        studentRepository.deleteById((long) id);
    }
}
