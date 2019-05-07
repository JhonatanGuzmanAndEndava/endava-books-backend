package com.endava.books.endavabooks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private String nickname;
    private LocalDate birthday;
    private String picture;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Book> writtenBooks;

}
