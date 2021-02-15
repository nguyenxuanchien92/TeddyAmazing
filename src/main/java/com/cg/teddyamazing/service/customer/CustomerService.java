package com.cg.teddyamazing.service.customer;


import com.cg.teddyamazing.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

}
