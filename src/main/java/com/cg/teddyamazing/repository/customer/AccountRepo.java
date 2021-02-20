package com.cg.teddyamazing.repository.customer;

import com.cg.teddyamazing.model.customer.Account;
import com.cg.teddyamazing.model.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepo extends PagingAndSortingRepository<Account, Long> {
}
