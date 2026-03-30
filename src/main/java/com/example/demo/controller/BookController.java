package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody BookDTO dto) {
        return bookService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO updateBook(@PathVariable int id, @RequestBody BookDTO dto) {
        return bookService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable int id) {
        bookService.delete(id);
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Book deleted successfully");
        body.put("id", id);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> search(@RequestParam(required = false) String author,
                                @RequestParam(required = false) String title) {
        return bookService.search(author, title);
    }
}
