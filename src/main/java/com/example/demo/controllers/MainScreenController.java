package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenController {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private final PartService partService;
    private final ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

    public MainScreenController(final PartService partService, final ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }

    @GetMapping("/mainscreen")
    public String listPartsProducts(final Model theModel, @Param("partkeyword") final String partkeyword, @Param("productkeyword") final String productkeyword){
        //add to the sprig model
        final List<Part> partList= this.partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        final List<Product> productList= this.productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
}
