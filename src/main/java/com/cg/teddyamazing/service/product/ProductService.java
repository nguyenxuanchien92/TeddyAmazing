package com.cg.teddyamazing.service.product;

import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(String id);

    void save(Product product);

    void remove(String id);

    Iterable<Product> findAllByCategory(Category category);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}