package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.dto.PublisherDto;
import com.endava.books.endavabooks.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        if(!(Optional.ofNullable(brand).isPresent()))
            return publisherService.getPublisher(publisherId).map(ResponseEntity::ok).get();
        return publisherService.getPublisherByBrand(brand).map(ResponseEntity::ok).get();
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        return ResponseEntity.ok(publisherService.getPublishers());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<PublisherDto> savePublisher(@RequestBody PublisherDto publisherDto) {
        return ResponseEntity.ok(publisherService.saveNewPublisher(publisherDto));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<PublisherDto> updatePublisher(@RequestParam(name = "id") Long publisherId, @RequestBody PublisherDto publisherDto) {
        return ResponseEntity.ok(publisherService.updatePublisher(publisherId, publisherDto));
    }

    @DeleteMapping(path = "/delete")
    public void deletePublisher(@RequestParam(name = "id") Long publisherId) {
        publisherService.deletePublisher(publisherId);
    }

}