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
    private String belowMinMessage;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(final ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        belowMinMessage = constraintAnnotation.belowMinMessage();
    }

    @Override
    public boolean isValid(final Product product, final ConstraintValidatorContext constraintValidatorContext) {
        if (null == this.context) {
            return true;
        }

        final ProductService productService = context.getBean(ProductServiceImpl.class);
        if (0 != product.getId()) {
            final Product existingProduct = productService.findById((int) product.getId());
            for (final Part p : existingProduct.getParts()) {
                // Check if inventory will be below minimum after adding/removing parts
                final int updatedPartInventory = p.getInv() - (product.getInv() - existingProduct.getInv());
                if (updatedPartInventory < p.getMinInventory()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(belowMinMessage)
                            .addConstraintViolation();
                    return false;
                }
            }
        }
        return true;
    }

}
