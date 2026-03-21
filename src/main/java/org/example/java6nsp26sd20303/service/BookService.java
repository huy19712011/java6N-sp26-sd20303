package org.example.java6nsp26sd20303.service;

import org.example.java6nsp26sd20303.dto.BookRequest;
import org.example.java6nsp26sd20303.dto.BookResponse;
import org.example.java6nsp26sd20303.entity.Book;

import java.util.List;

public interface BookService {

    List<BookResponse> findAll();

    BookResponse findById(long id);

    BookResponse add(BookRequest book);

    BookResponse update(BookRequest book, long id);

    void detete(long id);

}
