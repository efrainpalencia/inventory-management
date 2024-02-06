package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") final int theId, final Model theModel){

        final PartService repo= this.context.getBean(PartServiceImpl.class);
        final OutsourcedPartService outsourcedrepo= this.context.getBean(OutsourcedPartServiceImpl.class);
        final InhousePartService inhouserepo= this.context.getBean(InhousePartServiceImpl.class);

        boolean inhouse=true;
        final List<OutsourcedPart> outsourcedParts=outsourcedrepo.findAll();
        for(final OutsourcedPart outsourcedPart:outsourcedParts) {
            if (outsourcedPart.getId() == theId) {
                inhouse = false;
                break;
            }
        }
        final String formtype;
        if(inhouse){
            final InhousePart inhousePart=inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart",inhousePart);
            formtype="InhousePartForm";
        }
        else{
            final OutsourcedPart outsourcedPart=outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart",outsourcedPart);
            formtype="OutsourcedPartForm";
        }
        return formtype;
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") final int theId, final Model theModel){
        final PartService repo = this.context.getBean(PartServiceImpl.class);
        final Part part=repo.findById(theId);
        if(part.getProducts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

}
