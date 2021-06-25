package com.definex.devopstraining.service;

import com.definex.devopstraining.service.model.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
    BookDto findByTitle(String title);
    boolean create(BookDto book);
    boolean update(BookDto book);
}
