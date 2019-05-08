package com.endava.books.endavabooks.service;

import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.dto.PublisherDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PublisherService {

    Optional<PublisherDto> getPublisher(Long publisherId);

    Optional<PublisherDto> getPublisherByBrand(String brand);

    List<PublisherDto> getPublishers();

    Set<BookDto> getBooksFromPublisher(Long publisherId);

    PublisherDto saveNewPublisher(PublisherDto publisherDto);

    PublisherDto updatePublisher(Long publisherId, PublisherDto publisherDto);

    void deletePublisher(Long publisherId);
}