package com.cg.teddyamazing.controller.product;

import com.cg.teddyamazing.model.product.ManageProducts;

import com.cg.teddyamazing.service.product.ManagerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/quanly")
public class ManagerController {
    @Autowired
    public ManagerProductService managerProductService;
    @GetMapping
    public ModelAndView showHome(
//            @RequestParam("s") Optional<String> s,
//                                 @RequestParam("s1") Optional<String> s1,
                                 @RequestParam("page") Optional<Integer> page,
                                 Pageable pageable){
        Page<ManageProducts> manageProducts;
        List<ManageProducts> manageProducts1;
        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        pageable = PageRequest.of(pageNum, 10);
        manageProducts = managerProductService.findAll(pageable);

//   bug:     manageProducts1=managerProductService.findAllGroupBy();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("manageproducts", manageProducts);
        return modelAndView;

    }
}
