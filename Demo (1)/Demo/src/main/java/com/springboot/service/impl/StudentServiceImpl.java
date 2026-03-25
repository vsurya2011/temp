package com.springboot.service.impl;

import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public String printRegNo(int regNo) {
        return studentRepository.printRegNo(regNo);


    }
}
