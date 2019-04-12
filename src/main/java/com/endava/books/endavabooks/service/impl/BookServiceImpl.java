package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.assembler.impl.BookAssemblerImpl;
import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.model.Book;
import com.endava.books.endavabooks.repository.BookRepository;
import com.endava.books.endavabooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAssemblerImpl bookAssembler;

    @Override
    public BookDto saveNewBook(BookDto bookDto) {

        if(bookRepository.findById(bookDto.getISBN()).isPresent())
            throw new IllegalArgumentException("Book already exists");
        bookRepository.save(bookAssembler.toEntity(bookDto));

        Optional<Book> bookResponse = bookRepository.findById(bookDto.getISBN());

        return bookResponse.isPresent() ? bookAssembler.toDto(bookResponse.get()) : null;
    }
}