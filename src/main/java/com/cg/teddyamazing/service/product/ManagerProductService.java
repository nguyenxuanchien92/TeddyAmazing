package com.cg.teddyamazing.service.product;


import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManagerProductService {
    Page<ManageProducts> findAll(Pageable pageable);
//    List<ManageProducts> findAll2();

    ManageProducts findById(String id);

    void save(ManageProducts manageProducts);

    void remove(String id);

    Iterable<ManageProducts> findAllByProduct(Product product);

    List<ManageProducts> findAllGroupBy();

//    Page<ManageProducts> findAllByProduct_Name(String name, Pageable pageable);
}
