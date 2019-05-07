package com.endava.books.endavabooks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Book> publishedBooks;
}
