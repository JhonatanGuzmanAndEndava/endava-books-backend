package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.assembler.impl.BookAssemblerImpl;
import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.model.Author;
import com.endava.books.endavabooks.model.Book;
import com.endava.books.endavabooks.model.Publisher;
import com.endava.books.endavabooks.repository.AuthorRepository;
import com.endava.books.endavabooks.repository.BookRepository;
import com.endava.books.endavabooks.repository.PublisherRepository;
import com.endava.books.endavabooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookAssemblerImpl bookAssembler;

    @Override
    public BookDto saveNewBook(BookDto bookDto) {

        Optional<Author> authorOptional;
        Optional<Publisher> publisherOptional;

        if(bookRepository.findById(bookDto.getISBN()).isPresent())
            throw new IllegalArgumentException("Book already exists");

        Book bookToSave = bookAssembler.toEntity(bookDto);
        authorOptional = authorRepository.findById(bookDto.getAuthorId());
        publisherOptional = publisherRepository.findById(bookDto.getPublisherId());

        authorOptional.ifPresent(bookToSave::setAuthor);
        publisherOptional.ifPresent(bookToSave::setPublisher);
        return bookAssembler.toDto(bookRepository.save(bookToSave));
    }
}