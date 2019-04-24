package com.endava.books.endavabooks.service;

import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.dto.BookDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorService {

    Optional<AuthorDto> getAuthor(Long authorId);

    Optional<AuthorDto> getAuthorByName(String authorName);

    Optional<AuthorDto> getAuthorByNick(String authorNick);

    List<AuthorDto> getAuthors();

    Set<BookDto> getBooksFromAuthor(Long authorId);

    AuthorDto saveNewAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(Long authorId, AuthorDto authorDto);

    void deleteAuthor(Long authorId);
}
