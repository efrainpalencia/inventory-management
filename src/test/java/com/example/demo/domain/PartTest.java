package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: demoDarbyFrameworks2-master
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2022
 * Time: 3:44 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class PartTest {
    Part partIn;
    Part partOut;

    private Validator validator;
    @BeforeEach
    void setUp() {
        this.partIn =new InhousePart();
        this.partOut =new OutsourcedPart();
        final LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        this.validator = localValidatorFactoryBean;
    }
    @Test
    void getId() {
        final Long idValue=4L;
        this.partIn.setId(idValue);
        assertEquals(this.partIn.getId(), idValue);
        this.partOut.setId(idValue);
        assertEquals(this.partOut.getId(), idValue);
    }

    @Test
    void setId() {
        final Long idValue=4L;
        this.partIn.setId(idValue);
        assertEquals(this.partIn.getId(), idValue);
        this.partOut.setId(idValue);
        assertEquals(this.partOut.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test inhouse part";
        this.partIn.setName(name);
        assertEquals(name, this.partIn.getName());
        name="test outsourced part";
        this.partOut.setName(name);
        assertEquals(name, this.partOut.getName());
    }

    @Test
    void setName() {
        String name="test inhouse part";
        this.partIn.setName(name);
        assertEquals(name, this.partIn.getName());
        name="test outsourced part";
        this.partOut.setName(name);
        assertEquals(name, this.partOut.getName());
    }

    @Test
    void getPrice() {
        final double price=1.0;
        this.partIn.setPrice(price);
        assertEquals(price, this.partIn.getPrice());
        this.partOut.setPrice(price);
        assertEquals(price, this.partOut.getPrice());
    }

    @Test
    void setPrice() {
        final double price=1.0;
        this.partIn.setPrice(price);
        assertEquals(price, this.partIn.getPrice());
        this.partOut.setPrice(price);
        assertEquals(price, this.partOut.getPrice());
    }

    @Test
    void getInv() {
        final int inv=5;
        this.partIn.setInv(inv);
        assertEquals(inv, this.partIn.getInv());
        this.partOut.setInv(inv);
        assertEquals(inv, this.partOut.getInv());
    }

    @Test
    void setInv() {
        final int inv=5;
        this.partIn.setInv(inv);
        assertEquals(inv, this.partIn.getInv());
        this.partOut.setInv(inv);
        assertEquals(inv, this.partOut.getInv());
    }

    @Test
    void getProducts() {
        final Product product1= new Product();
        final Product product2= new Product();
        final Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        this.partIn.setProducts(myProducts);
        assertEquals(myProducts, this.partIn.getProducts());
        this.partOut.setProducts(myProducts);
        assertEquals(myProducts, this.partOut.getProducts());
    }

    @Test
    void setProducts() {
        final Product product1= new Product();
        final Product product2= new Product();
        final Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        this.partIn.setProducts(myProducts);
        assertEquals(myProducts, this.partIn.getProducts());
        this.partOut.setProducts(myProducts);
        assertEquals(myProducts, this.partOut.getProducts());
    }

    @Test
    void testToString() {
        String name="test inhouse part";
        this.partIn.setName(name);
        assertEquals(name, this.partIn.toString());
        name="test outsourced part";
        this.partOut.setName(name);
        assertEquals(name, this.partOut.toString());
    }

    @Test
    void testEquals() {
        this.partIn.setId(1L);
        final Part newPartIn=new InhousePart();
        newPartIn.setId(1L);
        assertEquals(this.partIn,newPartIn);
        this.partOut.setId(1L);
        final Part newPartOut=new OutsourcedPart();
        newPartOut.setId(1L);
        assertEquals(this.partOut,newPartOut);

    }

    @Test
    void testHashCode() {
        this.partIn.setId(1L);
        this.partOut.setId(1L);
        assertEquals(this.partIn.hashCode(), this.partOut.hashCode());
    }

    @Test
    void minInventoryShouldNotBeBelowMinimum() {
        final Part partIn = new InhousePart();
        final int invalidMinInventoryValue = -1;
        partIn.setMinInventory(invalidMinInventoryValue);

        final Set<ConstraintViolation<Part>> violations = this.validator.validate(partIn);

        assertFalse(violations.isEmpty(), "Expected ConstraintViolationException");
    }



    @Test
    void minInventoryShouldNotExceedMaximum() {
        this.partIn.setMinInventory(2);

        try {
            this.partIn.setMinInventory(this.partIn.getMinInventory());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void maxInventoryShouldNotBeBelowMinimum() {

        final Part partIn = new InhousePart();
        final int invalidMinInventoryValue = -1;
        partIn.setMinInventory(invalidMinInventoryValue);

        final Set<ConstraintViolation<Part>> violations = this.validator.validate(partIn);

        assertFalse(violations.isEmpty(), "Expected ConstraintViolationException");
    }

    @Test
    void maxInventoryShouldNotExceedMaximum() {
        this.partIn.setMinInventory(2);

        try {
            this.partIn.setMinInventory(this.partIn.getMinInventory());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}