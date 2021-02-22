package com.cg.teddyamazing.service.account.impl;

import com.cg.teddyamazing.model.account.Account;
import com.cg.teddyamazing.model.account.LevelRole;
import com.cg.teddyamazing.model.account.Role;
import com.cg.teddyamazing.repository.account.AccountRepo;
import com.cg.teddyamazing.repository.role.RoleRepo;
import com.cg.teddyamazing.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Iterable<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account save(Account model) {
        // create date account
        model.setCreateDate(currentDate());

        //set role default for account is ROLE_USER
        model.setRole(getRoleAccountDefault());
        return accountRepo.save(model);
    }

    @Override
    public void delete(Account model) {
        accountRepo.delete(model);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepo.findById(id);
    }


    private Date currentDate() {
        return new Date();
    }

    private Role getRoleAccountDefault(){
        Role role = roleRepo.findById(2L).get();
        return role;
    }

}
