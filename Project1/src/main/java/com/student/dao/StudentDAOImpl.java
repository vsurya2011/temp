package com.student.dao;

import com.student.model.Student;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students(name, gender, regno, email, dob) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setInt(3, student.getRegNo());
            ps.setString(4, student.getEmail());
            ps.setDate(5, student.getDob());

            ps.executeUpdate();
            System.out.println("Student inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int regNo) {
        String sql = "DELETE FROM students WHERE regno = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, regNo);
            ps.executeUpdate();

            System.out.println("Student deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findStudent(int regNo) {
        String sql = "SELECT * FROM students WHERE regno = ?";
        Student student = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, regNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setRegNo(rs.getInt("regno"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setSno(rs.getInt("sno"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setRegNo(rs.getInt("regno"));
                s.setEmail(rs.getString("email"));
                s.setDob(rs.getDate("dob"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}