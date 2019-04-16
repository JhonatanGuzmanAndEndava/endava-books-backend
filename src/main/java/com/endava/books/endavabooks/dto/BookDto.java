package com.endava.books.endavabooks.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    @EqualsAndHashCode.Include
    private String ISBN;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private String language;

    @EqualsAndHashCode.Exclude
    private String urlImage;

    @EqualsAndHashCode.Exclude
    private Long authorId;

    @EqualsAndHashCode.Exclude
    private Long publisherId;

}
