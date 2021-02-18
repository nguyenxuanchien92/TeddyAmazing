package com.cg.teddyamazing.service.customer.impl;

import com.cg.teddyamazing.model.customer.Customer;
import com.cg.teddyamazing.repository.customer.CustomerRepo;
import com.cg.teddyamazing.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return customerRepo.findAllByFirstNameContaining(firstName, pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }
}
