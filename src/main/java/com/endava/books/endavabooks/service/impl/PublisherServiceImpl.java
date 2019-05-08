package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.assembler.BookAssembler;
import com.endava.books.endavabooks.assembler.PublisherAssembler;
import com.endava.books.endavabooks.dto.BookDto;
import com.endava.books.endavabooks.dto.PublisherDto;
import com.endava.books.endavabooks.model.Publisher;
import com.endava.books.endavabooks.repository.PublisherRepository;
import com.endava.books.endavabooks.service.PublisherService;
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
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;
    private PublisherAssembler publisherAssembler;
    private BookAssembler bookAssembler;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherAssembler publisherAssembler,
                                BookAssembler bookAssembler) {
        this.publisherRepository = publisherRepository;
        this.publisherAssembler = publisherAssembler;
        this.bookAssembler = bookAssembler;
    }

    @Override
    public Optional<PublisherDto> getPublisher(Long publisherId) {
        getOptionalPublisher(publisherId).ifPresent(System.out::println);
        return getOptionalPublisher(publisherId).map(publisherAssembler::toDto);
    }

    @Override
    public Optional<PublisherDto> getPublisherByBrand(String brand) {
        return publisherRepository.findByBrand(brand).map(publisherAssembler::toDto);
    }

    @Override
    public List<PublisherDto> getPublishers() {
        return StreamSupport
                .stream(publisherRepository.findAll().spliterator(), false)
                .map(publisherAssembler::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Set<BookDto> getBooksFromPublisher(Long publisherId) {
        return getOptionalPublisher(publisherId).map(p -> bookAssembler.toDtos(p.getPublishedBooks())).get();
    }

    @Override
    public PublisherDto saveNewPublisher(PublisherDto publisherDto) {
        Publisher publisher = publisherAssembler.toEntity(publisherDto);
        return publisherAssembler.toDto(publisherRepository.save(publisher));
    }

    @Override
    public PublisherDto updatePublisher(Long publisherId, PublisherDto publisherDto) {
        Optional<Publisher> possiblePublisher = getOptionalPublisher(publisherId);
        if(possiblePublisher.isPresent()) {
            possiblePublisher.ifPresent(p -> p.setBrand(publisherDto.getBrand()));
            return publisherAssembler.toDto(publisherRepository.save(possiblePublisher.get()));
        } else
            throw new IllegalArgumentException("Publisher id does not exist");
    }

    @Override
    public void deletePublisher(Long publisherId) {
        publisherRepository.findById(publisherId).ifPresent(p -> p.getPublishedBooks().forEach(b -> b.setPublisher(null)));
        publisherRepository.deleteById(publisherId);
    }

    private Optional<Publisher> getOptionalPublisher(Long publisherId) {
        return publisherRepository.findById(publisherId);
    }
}
