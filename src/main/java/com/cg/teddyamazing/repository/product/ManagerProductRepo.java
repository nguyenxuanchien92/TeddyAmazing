package com.cg.teddyamazing.repository.product;

import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ManagerProductRepo extends PagingAndSortingRepository<ManageProducts, String> {
    Iterable<ManageProducts> findAllByProduct(Product product);

    @Query(nativeQuery = true, value ="SELECT c.product.id, sum(c.quantity) AS sumQuantity FROM  ManageProducts c GROUP BY c.product.id")
    List<ManageProducts> findAllGroupBy();
}
