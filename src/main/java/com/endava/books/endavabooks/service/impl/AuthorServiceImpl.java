package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.assembler.AuthorAssembler;
import com.endava.books.endavabooks.assembler.BookAssembler;
import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.model.Author;
import com.endava.books.endavabooks.repository.AuthorRepository;
import com.endava.books.endavabooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AuthorAssembler authorAssembler;
    private BookAssembler bookAssembler;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorAssembler authorAssembler, BookAssembler bookAssembler) {
        this.authorRepository = authorRepository;
        this.authorAssembler = authorAssembler;
        this.bookAssembler = bookAssembler;
    }

    @Override
    public Optional<AuthorDto> getAuthor(Long authorId) {
        return getOptionalAuthor(authorId).map(authorAssembler::toDto);
    }

    @Override
    public Optional<AuthorDto> getAuthorByName(String authorName) {
        return Optional.empty();
    }

    @Override
    public Optional<AuthorDto> getAuthorByNick(String authorNick) {
        return Optional.empty();
    }

    @Override
    public List<AuthorDto> getAuthors() {
        return null;
    }

    @Override
    public List<BookDto> getBooksFromAuthor(Long authorId) {
        return getOptionalAuthor(authorId).map(a -> bookAssembler.toDtos(a.getWrittenBooks())).get();
    }

    @Override
    public AuthorDto saveNewAuthor(AuthorDto authorDto) {
        Author author = authorAssembler.toEntity(authorDto);
        authorRepository.save(author);
        return authorAssembler.toDto(authorRepository.save(author));
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        return null;
    }

    @Override
    public void deleteAuthor(Long authorId) {

    }

    private Optional<Author> getOptionalAuthor(Long authorId) {
        return authorRepository.findById(authorId);
    }
}
