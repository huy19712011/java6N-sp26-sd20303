package org.example.java6nsp26sd20303.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    @Size(min = 3, message = "Description should have at least 3 characters")
    private String description;

    private boolean completed;
}
