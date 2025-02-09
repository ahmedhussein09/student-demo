package com.nbs.student.dao.entity;

import com.nbs.student.model.Gender;
import com.nbs.student.model.StudentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student extends AbstractPersistableEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String mobileNumber;
    private boolean status;
    private LocalDate joiningDate;

    public Student(StudentDto studentDto) {
        this.firstName = studentDto.getFirstName();
        this.lastName = studentDto.getLastName();
        this.age = studentDto.getAge();
        this.gender = studentDto.getGender();
        this.email = studentDto.getEmail();
        this.mobileNumber = studentDto.getMobileNumber();
        this.joiningDate = studentDto.getJoiningDate();
        this.status = true;
    }

    @Override
    public Integer getId() {
        return studentId;
    }
}
