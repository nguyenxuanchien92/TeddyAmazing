package com.cg.teddyamazing.repository.customer;

import com.cg.teddyamazing.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
//
//    Customer findById(Long id);
//
//    void delete(Long id);
}