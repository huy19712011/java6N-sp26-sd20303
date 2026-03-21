package org.example.java6nsp26sd20303.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponse {

    private String title;
    private String author;
    private double price;
    private String isbn;
}
