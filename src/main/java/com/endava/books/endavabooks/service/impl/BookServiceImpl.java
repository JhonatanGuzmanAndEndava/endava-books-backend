package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.repository.BookRepository;
import com.endava.books.endavabooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

}
