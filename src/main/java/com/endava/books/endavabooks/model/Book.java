package com.endava.books.endavabooks.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    private Author author;
    private String language;
    private String urlImage;

    @ManyToOne
    @JoinColumn
    @ToString.Exclude
    private Publisher publisher;

}
