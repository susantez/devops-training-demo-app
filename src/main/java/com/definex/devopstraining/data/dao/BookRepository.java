package com.definex.devopstraining.data.dao;

import com.definex.devopstraining.data.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
}
