package com.cg.teddyamazing;


import com.cg.teddyamazing.service.account.AccountService;
import com.cg.teddyamazing.service.account.impl.AccountServiceImpl;
import com.cg.teddyamazing.service.customer.CustomerService;
import com.cg.teddyamazing.service.customer.impl.CustomerServiceImpl;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import com.cg.teddyamazing.service.product.impl.CategoryServiceImpl;
import com.cg.teddyamazing.service.product.impl.ProductServiceImpl;
import com.cg.teddyamazing.service.product.impl.SizeServiceImpl;
import com.cg.teddyamazing.service.role.RoleService;
import com.cg.teddyamazing.service.role.impl.RoleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TeddyAmazingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeddyAmazingApplication.class, args);
    }
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }

    @Bean
    public SizeService sizeService(){
        return new SizeServiceImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl();
    }

    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl();
    }
}