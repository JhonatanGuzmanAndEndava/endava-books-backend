package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.assembler.BookAssembler;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookAssembler bookAssembler;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository,
                           BookAssembler bookAssembler) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookAssembler = bookAssembler;
    }

    @Override
    public Optional<BookDto> getBook(String ISBN) {
        return bookRepository.findById(ISBN).map(bookAssembler::toDto);
    }

    @Override
    public List<BookDto> getAll() {
        return bookAssembler.toDtos(
                StreamSupport
                        .stream(bookRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList())
        );
    }

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
        authorOptional.ifPresent(a -> a.getWrittenBooks().add(bookToSave));

        publisherOptional.ifPresent(bookToSave::setPublisher);
        publisherOptional.ifPresent(p -> p.getPublishedBooks().add(bookToSave));
        return bookAssembler.toDto(bookRepository.save(bookToSave));
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {

        Optional<Book> possibleBook = bookRepository.findById(bookDto.getISBN());
        if(possibleBook.isPresent()) {
            Book bookFound = possibleBook.get();

            bookFound.setName(bookDto.getName());
            bookFound.setLanguage(bookDto.getLanguage());
            bookFound.setUrlImage(bookDto.getUrlImage());

            authorRepository.findById(bookDto.getAuthorId()).ifPresent(bookFound::setAuthor);
            publisherRepository.findById(bookDto.getPublisherId()).ifPresent(bookFound::setPublisher);
            return bookAssembler.toDto(bookRepository.save(bookFound));
        }
        else
            throw new IllegalArgumentException("Book does not exist");
    }

    @Override
    public void deleteBook(String ISBN) {
        bookRepository.findById(ISBN).ifPresent(bookRepository::delete);
    }

    @Override
    public BookDto updateAuthor(String ISBN, Long authorId) {
        //TODO Fix bug to change author
        Optional<Book> possibleBook = bookRepository.findById(ISBN);
        Optional<Author> possibleAuthor = authorRepository.findById(authorId);

        if(possibleAuthor.isPresent() && possibleBook.isPresent()) {
            possibleBook.get().setAuthor(possibleAuthor.get());
            possibleAuthor.get().getWrittenBooks().add(possibleBook.get());
            return bookAssembler.toDto(bookRepository.save(possibleBook.get()));
        }else
            throw new IllegalArgumentException("Book or author do not exist");
    }

    @Override
    public BookDto updatePublisher(String ISBN, Long publisherId) {
        Optional<Book> possibleBook = bookRepository.findById(ISBN);
        Optional<Publisher> possiblePublisher = publisherRepository.findById(publisherId);

        if(possiblePublisher.isPresent() && possibleBook.isPresent()) {
            possibleBook.get().setPublisher(possiblePublisher.get());
            possiblePublisher.get().getPublishedBooks().add(possibleBook.get());
            return bookAssembler.toDto(bookRepository.save(possibleBook.get()));
        }else
            throw new IllegalArgumentException("Book or publisher do not exist");
    }
}