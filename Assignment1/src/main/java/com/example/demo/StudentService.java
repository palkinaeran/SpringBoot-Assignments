package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements InitializingBean, DisposableBean {

    private Map<Integer, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void updateStudentScore(int id, double newScore) {
        if (students.containsKey(id)) {
            Student student = students.get(id);
            double oldScore = student.getScore();
            student.setScore(newScore);

            // Log messages based on the scoring system
            if (newScore < 50) {
                System.out.println(student.getName() + " is Below Average.");
            } else if (newScore >= 50 && newScore <= 75) {
                System.out.println(student.getName() + " is Average.");
            } else {
                System.out.println(student.getName() + " is Above Average.");
            }
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        if (students.containsKey(id)) {
            students.remove(id);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("StudentService has been initialized.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("StudentService is being destroyed.");
    }
}
