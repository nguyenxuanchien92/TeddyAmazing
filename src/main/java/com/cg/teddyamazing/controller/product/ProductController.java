package com.cg.teddyamazing.controller.product;


import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.model.product.Product;
import com.cg.teddyamazing.model.product.Size;
import com.cg.teddyamazing.service.product.CategoryService;
import com.cg.teddyamazing.service.product.ProductService;
import com.cg.teddyamazing.service.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> provinces(){
        return categoryService.findAll();
    }

    @Autowired
    public ProductService productService;

    @Autowired
    private SizeService sizeService;

    @ModelAttribute("sizes")
    public Iterable<Size> sizes(){
        return sizeService.findAll();
    }


    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView showHome(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Product> products;
        System.out.println(s);

        if(s.isPresent()){
            products = productService.findAllByNameContaining(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/home");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.remove(id);
        return "redirect:/home";
    }

    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        System.out.println(product.getId());
        ModelAndView modelAndView = new ModelAndView("product/add");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/save-product")
    public ModelAndView editProduct (@ModelAttribute("product") Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }


}