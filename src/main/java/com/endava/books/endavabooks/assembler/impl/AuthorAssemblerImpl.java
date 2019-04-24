package com.endava.books.endavabooks.assembler.impl;

import com.endava.books.endavabooks.assembler.AuthorAssembler;
import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class AuthorAssemblerImpl implements AuthorAssembler {

    @Override
    public Author toEntity(AuthorDto authorDto) {
        //missing id
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setLastName(authorDto.getLastName());
        author.setNickname(authorDto.getNickname());
        author.setBirthday(authorDto.getBirthday());
        author.setPicture(authorDto.getPicture());
        author.setWrittenBooks(new HashSet<>());
        return author;
    }

    @Override
    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setLastName(author.getLastName());
        authorDto.setNickname(author.getNickname());
        authorDto.setBirthday(author.getBirthday());
        authorDto.setPicture(author.getPicture());
        return authorDto;
    }
}
