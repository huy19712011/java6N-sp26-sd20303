package org.example.java6nsp26sd20303.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java6nsp26sd20303.dto.BookRequest;
import org.example.java6nsp26sd20303.dto.BookResponse;
import org.example.java6nsp26sd20303.entity.Book;
import org.example.java6nsp26sd20303.exception.CustomResourceNotFoundException;
import org.example.java6nsp26sd20303.repository.BookRepository;
import org.example.java6nsp26sd20303.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .toList();
    }

    @Override
    public BookResponse findById(long id) {
        return bookRepository.findById(id)
                .map(book -> modelMapper.map(book, BookResponse.class))
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found for this id: " + id));
    }

    @Override
    public BookResponse add(BookRequest bookRequest) {

        Book book = modelMapper.map(bookRequest, Book.class);
        book.setIsbn(generateIsbn());

        bookRepository.save(book);

        BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
        return bookResponse;
    }

    private String generateIsbn() {

        return "ISBN-" + UUID.randomUUID().toString().substring(0, 13);
    }

    @Override
    public BookResponse update(BookRequest bookRequest, long id) {

        return bookRepository.findById(id)
                .map(b-> {
                    if (bookRequest.getTitle() != null) b.setTitle(bookRequest.getTitle());
                    if (bookRequest.getAuthor() != null) b.setAuthor(bookRequest.getAuthor());
                    if (bookRequest.getPrice() != 0) b.setPrice(bookRequest.getPrice());

                    bookRepository.save(b);
                    return modelMapper.map(b, BookResponse.class);
                })
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found for this id: " + id));
    }

    @Override
    public void detete(long id) {

        bookRepository.deleteById(id);
    }
}
