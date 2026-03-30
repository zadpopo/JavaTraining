package com.example.demo.service;

import com.example.demo.Book;
import com.example.demo.dao.BookDao;
import com.example.demo.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private final BookDao dao;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    public List<BookDTO> getAll() {
        return dao.findAll().stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }

    public BookDTO getById(int id) {
        Book book = dao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return BookDTO.from(book);
    }

    public BookDTO create(BookDTO dto) {
        Book toSave = new Book(null, dto.getAuthor(), dto.getTitle());
        Book saved = dao.save(toSave);
        return BookDTO.from(saved);
    }
    
    public BookDTO update(int id, BookDTO dto) {
        Book updated = dao.update(id, dto.getAuthor(), dto.getTitle());
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        return BookDTO.from(updated);
    }

    public void delete(int id) {
        boolean removed = dao.deleteById(id);
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    public List<BookDTO> search(String author, String title) {
        return dao.search(author, title).stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }
}