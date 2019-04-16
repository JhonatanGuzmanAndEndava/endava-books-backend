package com.endava.books.endavabooks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AuthorDto {

    private String name;
    private String lastName;
    private String nickname;
    private LocalDate birthday;
    private String picture;

}
