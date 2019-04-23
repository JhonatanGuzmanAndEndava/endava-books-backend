package com.endava.books.endavabooks.service.impl;

import com.endava.books.endavabooks.repository.PublisherRepository;
import com.endava.books.endavabooks.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

}
