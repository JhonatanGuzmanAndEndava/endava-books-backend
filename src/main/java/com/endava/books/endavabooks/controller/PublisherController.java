package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.dto.PublisherDto;
import com.endava.books.endavabooks.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/publisher")
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<PublisherDto> getPublisher(@RequestParam(name = "id", required = false) Long publisherId,
                                                     @RequestParam(name = "brand", required = false) String brand) {
        return null;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<PublisherDto> savePublisher(@RequestBody PublisherDto publisherDto) {
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<PublisherDto> updatePublisher(@RequestBody PublisherDto publisherDto) {
        return null;
    }

    @DeleteMapping(path = "/delete")
    public void deletePublisher(@RequestParam(name = "id") Long publisherId) {

    }

}
