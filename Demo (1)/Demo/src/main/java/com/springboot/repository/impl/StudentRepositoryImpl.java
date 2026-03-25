package com.springboot.repository.impl;

import com.springboot.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
@Profile("prod")
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    public StudentRepositoryImpl() {
        System.out.println("No args constructor- stuImpl");
    }

    @Override
    public String printRegNo(int regNo) {
        return String.format("My regno is %d",regNo);
    }
}
