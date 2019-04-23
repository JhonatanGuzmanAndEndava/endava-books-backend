package com.endava.books.endavabooks.service;

import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<AuthorDto> getAuthor(Long authorId);

    Optional<AuthorDto> getAuthorByName(String authorName);

    Optional<AuthorDto> getAuthorByNick(String authorNick);

    List<AuthorDto> getAuthors();

    List<BookDto> getBooksFromAuthor(Long authorId);

    AuthorDto saveNewAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(AuthorDto authorDto);

    void deleteAuthor(Long authorId);
}
