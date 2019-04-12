package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.repository.AuthorRepository;
import com.endava.books.endavabooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

}
