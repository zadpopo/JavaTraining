package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Eiichiro Oda", "One Piece"));
        books.add(new Book(2, "Masashi Kishimoto", "Naruto"));
        books.add(new Book(3, "Akira Toriyama", "Dragon Ball"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllBooks() {
        return books.stream()
                .map(BookDTO::from)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookById(@PathVariable int id) {
        return books.stream()
                .filter(b -> b.getId() != null && b.getId() == id)
                .findFirst()
                .map(BookDTO::from)
                .orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody Book newBook) {
        newBook.setId(books.size() + 1);
        books.add(newBook);
        return BookDTO.from(newBook);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> search(
    @RequestParam(required = false) String author,
    @RequestParam(required = false) String title) {
        return books.stream()
                .filter(b -> author == null ||
                        (b.getAuthor() != null && b.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .filter(b -> title == null ||
                        (b.getTitle() != null && b.getTitle().toLowerCase().contains(title.toLowerCase())))
                .map(BookDTO::from)
                .toList();
    }
}