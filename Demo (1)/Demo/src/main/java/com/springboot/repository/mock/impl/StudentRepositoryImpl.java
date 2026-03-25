package com.springboot.repository.mock.impl;

import com.springboot.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
@Profile("test")
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    public StudentRepositoryImpl() {
        System.out.println("stuImpl from mock");
    }

    @Override
    public String printRegNo(int regNo) {
        return String.format("My regno is %d",regNo);
    }
}
