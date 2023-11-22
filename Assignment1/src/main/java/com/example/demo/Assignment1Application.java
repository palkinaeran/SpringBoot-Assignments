package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(Assignment1Application.class, args);
		
	
	 // Demonstrate the usage of the StudentService
    StudentService studentService = ac.getBean(StudentService.class);

    // Add a few students
    studentService.addStudent(new Student(1, "Palkin", 60));
    studentService.addStudent(new Student(2, "Monika", 80));

    // Fetch and display the students
    System.out.println("All Students: " + studentService.getAllStudents());

    // Update scores and observe the scoring system logs
    studentService.updateStudentScore(1, 60);
    studentService.updateStudentScore(2, 80);

    // Remove a student
    studentService.deleteStudent(1);

    // Fetch and display the students after modifications
    System.out.println("All Students after modifications: " + studentService.getAllStudents());

    // Close the context to trigger the destroy() method
    ac.close();
}

}
