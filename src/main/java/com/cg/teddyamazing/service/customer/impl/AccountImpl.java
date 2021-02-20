package com.cg.teddyamazing.service.customer.impl;

import com.cg.teddyamazing.model.customer.Account;
import com.cg.teddyamazing.repository.customer.AccountRepo;
import com.cg.teddyamazing.service.customer.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account findById(Long id) {
        return accountRepo.findById(id).get();
    }
}
