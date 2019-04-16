package com.endava.books.endavabooks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany
    @JsonIgnore
    private List<Book> writtenBooks;

}
