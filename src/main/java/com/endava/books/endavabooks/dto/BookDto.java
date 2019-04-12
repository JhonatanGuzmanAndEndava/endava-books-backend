package com.endava.books.endavabooks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private String ISBN;
    private String name;
    private String author;
    private String language;
    private String publisher;

}
