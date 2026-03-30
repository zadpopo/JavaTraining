package com.example.demo;

public class BookDTO {
    private Integer id;
    private String author;
    private String title;

    public BookDTO() {}

    public BookDTO(Integer id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public static BookDTO from(Book b) {
        return new BookDTO(b.getId(), b.getAuthor(), b.getTitle());
    }

    public Integer getId() { 
    	return id; 
    }
    public void setId(Integer id) { 
    	this.id = id; 
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