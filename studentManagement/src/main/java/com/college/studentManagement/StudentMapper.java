package com.college.studentManagement;

import com.college.studentManagement.dto.StudentRequestDto;
import com.college.studentManagement.dto.StudentResponseDto;
import com.college.studentManagement.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequestDto dto){
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());
        student.setContact(dto.getContact());
        student.setLastName(dto.getLastName());
        student.setDepartment(dto.getDepartment());
        student.setEnrollmentId(dto.getEnrollmentId());

        return student;
    }

    public static StudentResponseDto toResponseDto(Student student){
        StudentResponseDto dto = new StudentResponseDto();

        dto.setId(student.getId());
        dto.setContact(student.getContact());

        return dto;
    }

    public static void updateEntity(Student student, StudentRequestDto dto) {
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAge(dto.getAge());
        student.setContact(dto.getContact());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        student.setDepartment(dto.getDepartment());
        student.setEnrollmentId(dto.getEnrollmentId());
    }

}
