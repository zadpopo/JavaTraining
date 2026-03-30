package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book(1, "One Piece", "Eiichiro Oda"));
        books.add(new Book(2, "Naruto", "Masashi Kishimoto"));
        books.add(new Book(3, "Dragon Ball", "Akira Toriyama"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
