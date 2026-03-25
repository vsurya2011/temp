package com.student.dao;

import com.student.model.Student;
import java.util.List;

public interface StudentDAO {
    void insertStudent(Student student);
    void deleteStudent(int regNo);
    Student findStudent(int regNo);
    List<Student> findAllStudents();
}