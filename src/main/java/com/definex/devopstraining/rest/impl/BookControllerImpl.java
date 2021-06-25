package com.definex.devopstraining.rest.impl;

import com.definex.devopstraining.rest.BookController;
import com.definex.devopstraining.service.BookService;
import com.definex.devopstraining.service.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookControllerImpl implements BookController {

    private BookService service;

    @Autowired
    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> response = service.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDto> findByTitle(String title) {
        BookDto response = service.findByTitle(title);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> createBook(@Valid BookDto book) {
        return null;
    }


}
