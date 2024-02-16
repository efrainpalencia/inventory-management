package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddProductController {
    @Autowired
    private ApplicationContext context;
    private final PartService partService;
    private List<Part> theParts;
    private static Product product1;
    private Product product;

    @GetMapping("/showFormAddProduct")
    public String showFormAddPart(final Model theModel) {
        theModel.addAttribute("parts", this.partService.findAll());
        this.product = new Product();
        AddProductController.product1 = this.product;
        theModel.addAttribute("product", this.product);

        final List<Part>availParts=new ArrayList<>();
        for(final Part p: this.partService.findAll()){
            if(!this.product.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        theModel.addAttribute("assparts", this.product.getParts());
        return "productForm";
    }

    @PostMapping("/showFormAddProduct")
    public String submitForm(@Valid @ModelAttribute("product") final Product product, final BindingResult bindingResult, final Model theModel) {
        theModel.addAttribute("product", product);

        if(bindingResult.hasErrors()){
            final ProductService productService = this.context.getBean(ProductServiceImpl.class);
            Product product2 = new Product();
            try {
                product2 = productService.findById((int) product.getId());
            } catch (final Exception e) {
                System.out.println("Error Message " + e.getMessage());
            }
            theModel.addAttribute("parts", this.partService.findAll());
            final List<Part>availParts=new ArrayList<>();
            for(final Part p: this.partService.findAll()){
                if(!product2.getParts().contains(p))availParts.add(p);
            }
            theModel.addAttribute("availparts",availParts);
            theModel.addAttribute("assparts",product2.getParts());
            return "productForm";
        }
//        theModel.addAttribute("assparts", assparts);
//        this.product=product;
//        product.getParts().addAll(assparts);
        else {
            final ProductService repo = this.context.getBean(ProductServiceImpl.class);
            if(0 != product.getId()) {
                final Product product2 = repo.findById((int) product.getId());
                final PartService partService1 = this.context.getBean(PartServiceImpl.class);
                if(0 < product.getInv() - product2.getInv()) {
                    for (final Part p : product2.getParts()) {
                        final int inv = p.getInv();
                        p.setInv(inv - (product.getInv() - product2.getInv()));
                        partService1.save(p);
                    }
                }
            }
            else{
                product.setInv(0);
            }
            repo.save(product);
            return "confirmationaddproduct";
        }
    }

    @GetMapping("/showProductFormForUpdate")
    public String showProductFormForUpdate(@RequestParam("productID") final int theId, final Model theModel) {
        theModel.addAttribute("parts", this.partService.findAll());
        final ProductService repo = this.context.getBean(ProductServiceImpl.class);
        final Product theProduct = repo.findById(theId);
        AddProductController.product1 =theProduct;
        //    this.product=product;
        //set the employ as a model attibute to prepopulate the form
        theModel.addAttribute("product", theProduct);
        theModel.addAttribute("assparts",theProduct.getParts());
        final List<Part>availParts=new ArrayList<>();
        for(final Part p: this.partService.findAll()){
            if(!theProduct.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        //send over to our form
        return "productForm";
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct(@RequestParam("productID") final int theId, final Model theModel) {
        final ProductService productService = this.context.getBean(ProductServiceImpl.class);
        final Product product2=productService.findById(theId);
        for(final Part part:product2.getParts()){
            part.getProducts().remove(product2);
            this.partService.save(part);
        }
        product2.getParts().removeAll(product2.getParts());
        productService.save(product2);
        productService.deleteById(theId);

        return "confirmationdeleteproduct";
    }

    @GetMapping("/buyproduct")
    public String buyProduct(@RequestParam("productID") final int theId, final Model theModel) {
        final ProductService productService = this.context.getBean(ProductServiceImpl.class);
        final Product product2=productService.findById(theId);
        final int currInventory = product2.getInv();
        if (0 < currInventory) {
            product2.setInv(currInventory - 1);
            productService.save(product2);
            return "confirmationbuyproduct";
        } else {
            return "buyproductfailed";
        }

    }

    public AddProductController(final PartService partService) {
        this.partService = partService;
    }
// make the add and remove buttons work

    @GetMapping("/associatepart")
    public String associatePart(@Valid @RequestParam("partID") final int theID, final Model theModel){
        //    theModel.addAttribute("product", product);
        //    Product product1=new Product();
        if (null == product1.getName()) {
            return "saveproductscreen";
        }
        else{
            AddProductController.product1.getParts().add(this.partService.findById(theID));
            this.partService.findById(theID).getProducts().add(AddProductController.product1);
            final ProductService productService = this.context.getBean(ProductServiceImpl.class);
            productService.save(AddProductController.product1);
            this.partService.save(this.partService.findById(theID));
            theModel.addAttribute("product", AddProductController.product1);
            theModel.addAttribute("assparts", AddProductController.product1.getParts());
            final List<Part>availParts=new ArrayList<>();
            for(final Part p: this.partService.findAll()){
                if(!AddProductController.product1.getParts().contains(p))availParts.add(p);
            }
            theModel.addAttribute("availparts",availParts);
            return "productForm";}
        //        return "confirmationassocpart";
    }
    @GetMapping("/removepart")
    public String removePart(@RequestParam("partID") final int theID, final Model theModel){
        theModel.addAttribute("product", this.product);
        //  Product product1=new Product();
        AddProductController.product1.getParts().remove(this.partService.findById(theID));
        this.partService.findById(theID).getProducts().remove(AddProductController.product1);
        final ProductService productService = this.context.getBean(ProductServiceImpl.class);
        productService.save(AddProductController.product1);
        this.partService.save(this.partService.findById(theID));
        theModel.addAttribute("product", AddProductController.product1);
        theModel.addAttribute("assparts", AddProductController.product1.getParts());
        final List<Part>availParts=new ArrayList<>();
        for(final Part p: this.partService.findAll()){
            if(!AddProductController.product1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "productForm";
    }
}
