package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(final ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Product product, final ConstraintValidatorContext constraintValidatorContext) {
        if(null == context) return true;
        if(null != context) EnufPartsValidator.myContext = this.context;
        final ProductService repo = EnufPartsValidator.myContext.getBean(ProductServiceImpl.class);
        if (0 != product.getId()) {
            final Product myProduct = repo.findById((int) product.getId());
            for (final Part p : myProduct.getParts()) {
                if (p.getInv()<(product.getInv()-myProduct.getInv()))return false;
            }
            return true;
        }
        else{
                return true;
            }
    }
}
