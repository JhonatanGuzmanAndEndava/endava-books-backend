package com.endava.books.endavabooks.assembler.impl;

import com.endava.books.endavabooks.assembler.PublisherAssembler;
import com.endava.books.endavabooks.dto.PublisherDto;
import com.endava.books.endavabooks.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherAssemblerImpl implements PublisherAssembler {

    @Override
    public Publisher toEntity(PublisherDto publisherDto) {
        return null;
    }

    @Override
    public PublisherDto toDto(Publisher publisher) {
        return null;
    }
}
