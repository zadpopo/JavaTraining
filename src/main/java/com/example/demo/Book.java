package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    public Book() {}

    public Book(Integer id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
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