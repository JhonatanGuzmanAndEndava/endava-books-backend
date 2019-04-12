package com.endava.books.endavabooks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private String ISBN;
    private String name;
    private String language;
    private Long authorId;
    private Long publisherId;

    @Override
    public boolean equals(Object obj) {
        return this.ISBN.equals(((BookDto) obj).getISBN());
    }

}
