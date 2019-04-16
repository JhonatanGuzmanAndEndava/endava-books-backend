package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<BookDto> getBook(@RequestParam(name = "isbn") String ISBN) {
        Optional<BookDto> bookResponse = bookService.getBook(ISBN);
        return bookResponse.isPresent() ? ResponseEntity.ok(bookResponse.get()) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.saveNewBook(bookDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(bookDto));
    }

    @DeleteMapping(path = "/delete")
    public void deleteBook(@RequestParam(name = "isbn") String ISBN) {
        bookService.deleteBook(ISBN);
    }

    @PutMapping(path = "/{book}/author")
    public ResponseEntity addAuthor(@PathVariable(name = "book") String ISBN, @RequestParam(name = "id") Long authorId) {
        return ResponseEntity.ok(bookService.updateAuthor(ISBN, authorId));
    }

    @PutMapping(path = "/{book}/publisher")
    public ResponseEntity addPublisher(@PathVariable(name = "book") String ISBN, @RequestParam(name = "id") Long publisherId) {
        return ResponseEntity.ok(bookService.updatePublisher(ISBN, publisherId));
    }

}
