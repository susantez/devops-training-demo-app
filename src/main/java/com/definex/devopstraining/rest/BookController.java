package com.definex.devopstraining.rest;

import com.definex.devopstraining.service.model.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping(value = "/training/v1")
public interface BookController {

    @GetMapping(value = "/book/all")
    ResponseEntity<List<BookDto>> findAll();

    @GetMapping(value = "/book/{title}")
    ResponseEntity<BookDto> findByTitle(@PathVariable String title);

    @PostMapping(value = "/book/create")
    ResponseEntity<Boolean> createBook(@Valid @RequestBody BookDto book);

}
