package com.example.demo.dao;

import com.example.demo.Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BookDao {

    private final Map<Integer, Book> store = new ConcurrentHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public BookDao() {
        save(new Book(null, "Eiichiro Oda", "One Piece"));
        save(new Book(null, "Masashi Kishimoto", "Naruto"));
        save(new Book(null, "Akira Toriyama", "Dragon Ball"));
    }

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Book> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    public Book save(Book b) {
        if (b.getId() == null) {
            b.setId(seq.incrementAndGet());
        }
        store.put(b.getId(), b);
        return b;
    }
    
    public Book update(int id, String author, String title) {
        Book existing = store.get(id);
        if (existing == null) {
            return null;
        }
        if (author != null) existing.setAuthor(author);
        if (title  != null) existing.setTitle(title);
        store.put(id, existing);
        return existing;
    }

    public boolean deleteById(int id) {
        return store.remove(id) != null;
    }

    public List<Book> search(String author, String title) {
        return store.values().stream()
                .filter(b -> author == null || (b.getAuthor() != null &&
                        b.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .filter(b -> title == null || (b.getTitle() != null &&
                        b.getTitle().toLowerCase().contains(title.toLowerCase())))
                .collect(Collectors.toList());
    }
}