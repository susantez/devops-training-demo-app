package com.definex.devopstraining;

import com.definex.devopstraining.data.dao.BookRepository;
import com.definex.devopstraining.data.model.Book;
import com.definex.devopstraining.service.BookService;
import com.definex.devopstraining.service.model.BookDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DevopsTrainingApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;




    @Test
    public void getBookTest(){

        Mockito.when(bookRepository.findAll()).thenReturn(Stream
                .of(new Book(),new Book(),new Book()).collect(Collectors.toList()));
        List<BookDto> bookList2 = bookService.findAll();
        assertEquals(3,bookList2.size());

    }



}
