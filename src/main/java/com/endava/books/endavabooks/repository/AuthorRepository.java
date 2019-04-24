package com.endava.books.endavabooks.repository;

import com.endava.books.endavabooks.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByName(String name);

    Optional<Author> findByNickname(String nickname);
}
