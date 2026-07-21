package com.college.studentManagement.service;

import com.college.studentManagement.StudentMapper;
import com.college.studentManagement.dto.StudentRequestDto;
import com.college.studentManagement.dto.StudentResponseDto;
import com.college.studentManagement.entity.Student;
import com.college.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImp1 implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentResponseDto addStudent(StudentRequestDto dto){
        Student student = StudentMapper.toEntity(dto);

        Student savedStudent = repository.save(student);

        return StudentMapper.toResponseDto(savedStudent);
    }

    @Override
    public StudentResponseDto getStudent(Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.toResponseDto(student);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {

        List<StudentResponseDto> students = repository.findAll()
                .stream()
                .map(StudentMapper::toResponseDto)
                .toList();

        return students;
    }

    @Override
    public StudentResponseDto updateStudent(Integer id, StudentRequestDto dto){
        Student student = repository.getReferenceById(id);
        StudentMapper.updateEntity(student,dto);
        Student updatedStudent = repository.save(student);
        return StudentMapper.toResponseDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        repository.delete(student);
    }
}

