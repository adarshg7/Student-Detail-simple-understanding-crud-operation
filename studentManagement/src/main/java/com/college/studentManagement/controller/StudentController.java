package com.college.studentManagement.controller;
import com.college.studentManagement.dto.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.college.studentManagement.dto.StudentRequestDto;
import com.college.studentManagement.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto dto){
        return service.addStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable Integer id){
        return service.getStudent(id);
    }

    @PutMapping("{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDto dto){
        return service.updateStudent(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        service.deleteStudent(id);
    }
}
