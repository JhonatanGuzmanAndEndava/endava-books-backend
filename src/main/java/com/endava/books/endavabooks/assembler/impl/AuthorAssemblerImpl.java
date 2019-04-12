package com.endava.books.endavabooks.assembler.impl;

import com.endava.books.endavabooks.assembler.AuthorAssembler;
import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorAssemblerImpl implements AuthorAssembler {

    @Override
    public Author toEntity(AuthorDto authorDto) {
        return null;
    }

    @Override
    public AuthorDto toDto(Author author) {
        return null;
    }
}
