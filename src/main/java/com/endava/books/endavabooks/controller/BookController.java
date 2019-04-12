package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.model.Book;
import com.endava.books.endavabooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/add")
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {

        BookDto b1 = new BookDto();
        BookDto b2 = new BookDto();

        b1.setISBN("asdf");
        b2.setISBN("asdf");

        b1.setName("Harry Potter");
        b1.setName("Cien años de soledad");

        System.out.println(b1.equals(b2));

        return ResponseEntity.ok(bookService.saveNewBook(bookDto));
    }
}
