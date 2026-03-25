package com.student.model;

import java.sql.Date;

public class Student {
    private int sno;
    private String name;
    private String gender;
    private int regNo;
    private String email;
    private Date dob;

    public Student() {}

    public Student(String name, String gender, int regNo, String email, Date dob) {
        this.name = name;
        this.gender = gender;
        this.regNo = regNo;
        this.email = email;
        this.dob = dob;
    }

    // Getters and Setters
    public int getSno() { return sno; }
    public void setSno(int sno) { this.sno = sno; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getRegNo() { return regNo; }
    public void setRegNo(int regNo) { this.regNo = regNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
}