package com.hexagonal.architecture.adapter.persistence;

import com.hexagonal.architecture.domain.model.Book;
import com.hexagonal.architecture.domain.port.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaBookRepositoryAdapter implements BookRepository {

    private final JpaBookRepository jpaBookRepository;

    public JpaBookRepositoryAdapter(JpaBookRepository jpaBookRepository) {
        this.jpaBookRepository = jpaBookRepository;
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = new BookEntity(book.getId(), book.getTitle(), book.getAuthor());
        BookEntity savedEntity = jpaBookRepository.save(entity);
        return new Book(savedEntity.getId(), savedEntity.getTitle(), savedEntity.getAuthor());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaBookRepository.findById(id).map(entity -> new Book(entity.getId(), entity.getTitle(), entity.getAuthor()));
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll().stream()
                .map(entity -> new Book(entity.getId(), entity.getTitle(), entity.getAuthor())).collect(Collectors.toList());
    }
}
