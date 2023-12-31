package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Classroom {

    private Student student;

    @Autowired
    public Classroom(Student student) {
        this.student = student;
    }

    public void displayStudentDetails() {
        System.out.println("Student Details: Name - " + student.getName() + ", Age - " + student.getAge());
    }
}