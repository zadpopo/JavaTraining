package com.example.demo.service;

import com.example.demo.Book;
import com.example.demo.dao.BookRepository;
import com.example.demo.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<BookDTO> getAll() {
        return repo.findAll().stream().map(BookDTO::from).toList();
    }

    public BookDTO getById(int id) {
        Book b = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return BookDTO.from(b);
    }

    public BookDTO create(BookDTO dto) {
        Book saved = repo.save(new Book(null, dto.getAuthor(), dto.getTitle()));
        return BookDTO.from(saved);
    }

    public BookDTO update(int id, BookDTO dto) {
        Book b = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        if (dto.getAuthor() != null) b.setAuthor(dto.getAuthor());
        if (dto.getTitle()  != null) b.setTitle(dto.getTitle());
        return BookDTO.from(repo.save(b));
    }

    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        repo.deleteById(id);
    }

    public List<BookDTO> search(String author, String title) {
        boolean hasAuthor = author != null && !author.isBlank();
        boolean hasTitle  = title  != null && !title.isBlank();

        if (hasAuthor && hasTitle) {
            return repo.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title)
                       .stream().map(BookDTO::from).toList();
        } else if (hasAuthor) {
            return repo.findByAuthorContainingIgnoreCase(author).stream().map(BookDTO::from).toList();
        } else if (hasTitle) {
            return repo.findByTitleContainingIgnoreCase(title).stream().map(BookDTO::from).toList();
        } else {
            return getAll();
        }
    }
}