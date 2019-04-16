package com.endava.books.endavabooks.controller;

import com.endava.books.endavabooks.dto.AuthorDto;
import com.endava.books.endavabooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<AuthorDto> getBook(@RequestParam(name = "id", required = false) Long authorId,
                                             @RequestParam(name = "name", required = false) String name) {
        return null;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AuthorDto> saveAuthor(@RequestBody AuthorDto authorDto) {
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto) {
        return null;
    }

    @DeleteMapping(path = "/delete")
    public void deleteAuthor(@RequestParam(name = "id") Long authorId) {

    }
}
