package com.example.demo.dto;

import com.example.demo.Book;

public class BookDTO {

    private String author;
    private String title;

    public BookDTO() {}

    public BookDTO(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public static BookDTO from(Book b) {
        return new BookDTO(b.getAuthor(), b.getTitle());
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}