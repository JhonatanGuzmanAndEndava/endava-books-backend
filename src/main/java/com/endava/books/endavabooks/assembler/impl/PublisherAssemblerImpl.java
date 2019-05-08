package com.endava.books.endavabooks.assembler.impl;

import com.endava.books.endavabooks.assembler.PublisherAssembler;
import com.endava.books.endavabooks.dto.PublisherDto;
import com.endava.books.endavabooks.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class PublisherAssemblerImpl implements PublisherAssembler {

    @Override
    public Publisher toEntity(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setBrand(publisherDto.getBrand());
        publisher.setPublishedBooks(new HashSet<>());
        return publisher;
    }

    @Override
    public PublisherDto toDto(Publisher publisher) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setBrand(publisher.getBrand());
        return publisherDto;
    }
}
