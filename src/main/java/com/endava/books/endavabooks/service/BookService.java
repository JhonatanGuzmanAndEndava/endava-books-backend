package com.endava.books.endavabooks.service;

import com.endava.books.endavabooks.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<BookDto> getBook(String ISBN);

    List<BookDto> getAll();

    BookDto saveNewBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);

    void deleteBook(String ISBN);

    BookDto updateAuthor(String ISBN, Long authorId);

    BookDto updatePublisher(String ISBN, Long publisherId);

}
