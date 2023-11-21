package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
public class Library {
	@Autowired
    private Book book;

    public void displayBookDetails() {
        System.out.println("Book Details: Title - " + book.getTitle() + ", Author - " + book.getAuthor());
    }

	

}
