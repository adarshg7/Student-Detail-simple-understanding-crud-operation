package com.college.studentManagement.service;

import com.college.studentManagement.dto.StudentRequestDto;
import com.college.studentManagement.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto addStudent(StudentRequestDto dto);
    StudentResponseDto getStudent(Integer id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Integer id, StudentRequestDto dto);
    void deleteStudent(Integer id);
}
