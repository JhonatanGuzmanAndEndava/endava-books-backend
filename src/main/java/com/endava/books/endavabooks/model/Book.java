package com.endava.books.endavabooks.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private String ISBN;
    private String name;

    @ManyToOne
    @JoinColumn
    private Author author;
    private String language;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

}
