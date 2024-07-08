package com.hexagonal.architecture.config;

import com.hexagonal.architecture.adapter.persistence.JpaBookRepository;
import com.hexagonal.architecture.adapter.persistence.JpaBookRepositoryAdapter;
import com.hexagonal.architecture.domain.port.BookRepository;
import com.hexagonal.architecture.domain.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookRepository bookRepository(JpaBookRepository jpaBookRepository) {
        return new JpaBookRepositoryAdapter(jpaBookRepository);
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }
}