package com.cg.teddyamazing.repository.account;

import com.cg.teddyamazing.model.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepo extends PagingAndSortingRepository<Account, Long> {
    Account findByUserName(String userName);
}
