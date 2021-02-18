package com.cg.teddyamazing.controller.customer;


import com.cg.teddyamazing.model.customer.Customer;
import com.cg.teddyamazing.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;

    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/customer/create");
        }
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }



//    @GetMapping("/customers")
//    public ModelAndView listCustomers(@RequestParam("s") Optional<String> keyword, @RequestParam("page") Optional<Integer> page){
//        Page<Customer> customers;
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        int pageNumb = 0;
//        if(page.isPresent() && page.get() > 1) pageNumb = page.get() - 1;
////        PageRequest pageSplitter = new PageRequest(pageNumb,4);
//        if(keyword.isPresent()){
//            customers = customerService.findAllByFirstNameContaining(keyword.get(), pageSplitter);
//            modelAndView.addObject("keyword", keyword.get());
//        } else {
//            customers = customerService.findAll(pageSplitter);
//        }
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//
//
//
////        if (page.isPresent() && page.get() > 1){
////            pageNumb = page.get() - 1;
////        }
////
////        PageRequest pageRequest = new PageRequest(pageNumb,4,new Sort("firstName"));
////        if (keyword.isPresent()){
////            customers = customerService.findAllByFirstNameContaining(keyword.get(), pageRequest);
////            modelAndView.addObject("keyword",keyword.get());
////        } else {
////            customers = customerService.findAll(pageRequest);
////        }
////
////        modelAndView.addObject("customers", customers);
////        return modelAndView;
//
//    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@RequestParam("id") Long id){
        customerService.remove(id);
        return "redirect:/customers";
    }
}