package com.hibernate.entity;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="owner_table")
public class Owner {
    @Id
    private int id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;


    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private int petId;
    private String petName;
    private LocalDate petBirthDate;
    private Gender petGender;
    private PetType petType;
}
