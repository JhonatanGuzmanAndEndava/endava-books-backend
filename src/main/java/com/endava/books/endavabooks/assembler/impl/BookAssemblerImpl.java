package com.endava.books.endavabooks.assembler.impl;

import com.endava.books.endavabooks.assembler.BookAssembler;
import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.model.Author;
import com.endava.books.endavabooks.model.Book;
import com.endava.books.endavabooks.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookAssemblerImpl implements BookAssembler {

    @Override
    public Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setISBN(bookDto.getISBN());
        book.setName(bookDto.getName());
        book.setLanguage(bookDto.getLanguage());
        book.setUrlImage(bookDto.getUrlImage());
        return book;
    }

    @Override
    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setName(book.getName());
        bookDto.setISBN(book.getISBN());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setUrlImage(book.getUrlImage());

        Optional<Author> authorOptional = Optional.ofNullable(book.getAuthor());
        Optional<Publisher> publisherOptional = Optional.ofNullable(book.getPublisher());

        Optional<Long> authorId = Optional.ofNullable(authorOptional.orElse(new Author()).getId());
        Optional<Long> publisherId = Optional.ofNullable(publisherOptional.orElse(new Publisher()).getId());

        bookDto.setAuthorId(authorId.orElse(-1L));
        bookDto.setPublisherId(publisherId.orElse(-1L));
        return bookDto;
    }
}
