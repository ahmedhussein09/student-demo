package com.nbs.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nbs.student.dao.entity.Student;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDto {
    private int studentId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Min(value = 0)
    @Max(value = 100)
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    @Pattern(regexp = "^(010|011|012|015)\\d{8}$")
    private String mobileNumber;
    private boolean status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    public StudentDto(Student student) {
        this.studentId = student.getStudentId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.age = student.getAge();
        this.gender = student.getGender();
        this.email = student.getEmail();
        this.status = student.isStatus();
        this.joiningDate = student.getJoiningDate();
    }

}
