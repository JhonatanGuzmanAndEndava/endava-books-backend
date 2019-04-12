package com.endava.books.endavabooks.repository;

import com.endava.books.endavabooks.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
