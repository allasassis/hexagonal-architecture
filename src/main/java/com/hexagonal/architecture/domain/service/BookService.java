package com.hexagonal.architecture.domain.service;

import com.hexagonal.architecture.domain.model.Book;
import com.hexagonal.architecture.domain.port.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
