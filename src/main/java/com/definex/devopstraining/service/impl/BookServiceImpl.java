package com.definex.devopstraining.service.impl;

import com.definex.devopstraining.data.dao.BookRepository;
import com.definex.devopstraining.data.model.Book;
import com.definex.devopstraining.service.BookService;
import com.definex.devopstraining.service.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookDto> findAll() {
        Iterable<Book> books = repository.findAll();
        List<BookDto> result = new ArrayList<BookDto>();

        for(Book book: books) {
            result.add(mapToBookDto(book));
        }
        return result;
    }

    @Override
    public BookDto findByTitle(String title) {
        Book result = repository.findByTitle(title);
        return mapToBookDto(result);
    }

    @Override
    public boolean create(BookDto book) {
        return false;
    }

    @Override
    public boolean update(BookDto book) {
        return false;
    }

    private BookDto mapToBookDto(Book book) {
        if (book == null) {
            return new BookDto();
        }
        BookDto dto = new BookDto();
        dto.setAuthor(book.getAuthor());
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        return dto;
    }
    private Book mapToBook(BookDto dto) {
        if (dto == null) {
            return new Book();
        }
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        return book;
    }

}
