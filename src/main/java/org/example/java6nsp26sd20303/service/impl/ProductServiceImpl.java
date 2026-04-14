package org.example.java6nsp26sd20303.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java6nsp26sd20303.entity.Product;
import org.example.java6nsp26sd20303.exception.CustomResourceNotFoundException;
import org.example.java6nsp26sd20303.repository.ProductRepository;
import org.example.java6nsp26sd20303.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Product not found for this id: " + id));
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, long id) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    if (product.getName() != null) {
                        existingProduct.setName(product.getName());
                    }
                    if (product.getPrice() != null) {
                        existingProduct.setPrice(product.getPrice());
                    }
                    if (product.getCategory() != null) {
                        existingProduct.setCategory(product.getCategory());
                    }
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new CustomResourceNotFoundException("Product not found for this id: " + id));
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Product not found for this id: " + id));
        
        // Remove product from category before deletion
        if (product.getCategory() != null) {
            product.getCategory().getProducts().remove(product);
        }
        
        productRepository.delete(product);
    }
}

