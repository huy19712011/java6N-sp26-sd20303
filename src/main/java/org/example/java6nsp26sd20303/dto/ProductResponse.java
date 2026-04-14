package org.example.java6nsp26sd20303.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String name;
    private Double price;
    private Long categoryId;
    private String categoryName;
}

