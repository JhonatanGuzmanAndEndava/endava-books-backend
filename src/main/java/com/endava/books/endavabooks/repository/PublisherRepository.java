package com.endava.books.endavabooks.repository;

import com.endava.books.endavabooks.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    Optional<Publisher> findByBrand(String brand);

}
