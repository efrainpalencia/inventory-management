package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.InhousePartServiceImpl;
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
public class PriceProductValidator implements ConstraintValidator<ValidProductPrice, Product> {
    @Autowired
    private ApplicationContext context;

    public static  ApplicationContext myContext;

    @Override
    public void initialize(final ValidProductPrice constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Product product, final ConstraintValidatorContext constraintValidatorContext) {
        if(null == context) return true;
        if(null != context) PriceProductValidator.myContext = this.context;
        final ProductService repo = PriceProductValidator.myContext.getBean(ProductServiceImpl.class);
        double sumPartsPrice = 0;
        if (0 != product.getId()) {
            final Product myProduct = repo.findById((int) product.getId());
            for (final Part p : myProduct.getParts()) sumPartsPrice = sumPartsPrice + p.getPrice();
            return product.getPrice() >= sumPartsPrice;
        }
        else {
            return true;
        }
    }
}
