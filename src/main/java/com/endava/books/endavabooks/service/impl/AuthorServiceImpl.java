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
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        //TODO Only for testing - remove it later
        getOptionalAuthor(authorId).ifPresent(System.out::println);
        return getOptionalAuthor(authorId).map(authorAssembler::toDto);
    }

    @Override
    public Optional<AuthorDto> getAuthorByName(String authorName) {
        //TODO Regex
        return authorRepository.findByName(authorName).map(authorAssembler::toDto);
    }

    @Override
    public Optional<AuthorDto> getAuthorByNick(String authorNick) {
        //TODO Regex
        return authorRepository.findByNickname(authorNick).map(authorAssembler::toDto);
    }

    @Override
    public List<AuthorDto> getAuthors() {
        return StreamSupport
                .stream(authorRepository.findAll().spliterator(), false)
                .map(authorAssembler::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Set<BookDto> getBooksFromAuthor(Long authorId) {
        return getOptionalAuthor(authorId).map(a -> bookAssembler.toDtos(a.getWrittenBooks())).get();
    }

    @Override
    public AuthorDto saveNewAuthor(AuthorDto authorDto) {
        Author author = authorAssembler.toEntity(authorDto);
        return authorAssembler.toDto(authorRepository.save(author));
    }

    @Override
    public AuthorDto updateAuthor(Long authorId, AuthorDto authorDto) {
        Optional<Author> possibleAuthor = getOptionalAuthor(authorId);
        if(possibleAuthor.isPresent()) {
            possibleAuthor.get().setName(authorDto.getName());
            possibleAuthor.get().setLastName(authorDto.getLastName());
            possibleAuthor.get().setNickname(authorDto.getNickname());
            possibleAuthor.get().setPicture(authorDto.getPicture());
            possibleAuthor.get().setBirthday(authorDto.getBirthday());
            return authorAssembler.toDto(authorRepository.save(possibleAuthor.get()));
        }else
            throw new IllegalArgumentException("Author id does not exist");
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.findById(authorId).ifPresent(a -> a.getWrittenBooks().forEach(b -> b.setAuthor(null)));
        authorRepository.deleteById(authorId);
    }

    private Optional<Author> getOptionalAuthor(Long authorId) {
        return authorRepository.findById(authorId);
    }
}
