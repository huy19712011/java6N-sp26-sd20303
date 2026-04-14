package org.example.java6nsp26sd20303.service;

import org.example.java6nsp26sd20303.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product add(Product product);

    Product update(Product product, long id);

    void delete(long id);
}

