package com.cg.teddyamazing;


import com.cg.teddyamazing.service.customer.AccountService;
import com.cg.teddyamazing.service.customer.CustomerService;
import com.cg.teddyamazing.service.customer.impl.AccountImpl;
import com.cg.teddyamazing.service.customer.impl.CustomerServiceImpl;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ManagerProductService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import com.cg.teddyamazing.service.product.impl.CategoryServiceImpl;
import com.cg.teddyamazing.service.product.impl.ManagerServiceImpl;
import com.cg.teddyamazing.service.product.impl.ProductServiceImpl;
import com.cg.teddyamazing.service.product.impl.SizeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
    public ManagerProductService managerProductService(){
        return new ManagerServiceImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public AccountService accountService(){
        return new AccountImpl();
    }
}