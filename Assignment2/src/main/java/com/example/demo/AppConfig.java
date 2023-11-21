package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book book() {
        Book book = new Book();
        book.setTitle("7 wonders");
        book.setAuthor("10 hours");
        return book;
    }

    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Palkin");
        student.setAge(20);
        return student;
    }

    @Bean
    public Library library(Book book) {
        Library library = new Library();
        library.setBook(book);
        return library;
    }

    @Bean
    public Classroom classroom(Student student) {
        return new Classroom(student);
    }
}