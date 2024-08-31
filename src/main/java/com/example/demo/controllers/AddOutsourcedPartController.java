package com.example.demo.controllers;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(final Model theModel){
        final Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "outsourcedpartform";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") final OutsourcedPart part, final BindingResult theBindingResult, final Model theModel){
        theModel.addAttribute("outsourcedpart",part);

        if (part.getInv() < part.getMinInventory() || part.getInv() > part.getMaxInventory()) {
            theBindingResult.rejectValue("inv", "inventory.range",
                    "Inventory must be between " + part.getMinInventory() + " and " + part.getMaxInventory());
        }

        if(theBindingResult.hasErrors()){
            return "outsourcedpartform";
        }
        else{
        final OutsourcedPartService repo= this.context.getBean(OutsourcedPartServiceImpl.class);
        final OutsourcedPart op=repo.findById((int)part.getId());
        if(null != op)part.setProducts(op.getProducts());
            repo.save(part);
        return "confirmationaddpart";}
    }



}
