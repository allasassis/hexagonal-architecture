package com.hexagonal.architecture.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class JpaBookRepository implements JpaRepository<BookEntity, Long> {
}
