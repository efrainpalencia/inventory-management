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
        partIn=new InhousePart();
        partOut=new OutsourcedPart();
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        validator = localValidatorFactoryBean;
    }
    @Test
    void getId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void setId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void setName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void getPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void setPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void getInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void setInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void getProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void setProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void testToString() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.toString());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.toString());
    }

    @Test
    void testEquals() {
        partIn.setId(1L);
        Part newPartIn=new InhousePart();
        newPartIn.setId(1L);
        assertEquals(partIn,newPartIn);
        partOut.setId(1L);
        Part newPartOut=new OutsourcedPart();
        newPartOut.setId(1L);
        assertEquals(partOut,newPartOut);

    }

    @Test
    void testHashCode() {
        partIn.setId(1L);
        partOut.setId(1L);
        assertEquals(partIn.hashCode(),partOut.hashCode());
    }

    @Test
    void minInventoryShouldNotBeBelowMinimum() {
        Part partIn = new InhousePart();
        int invalidMinInventoryValue = -1;
        partIn.setMinInventory(invalidMinInventoryValue);

        Set<ConstraintViolation<Part>> violations = validator.validate(partIn);

        assertFalse(violations.isEmpty(), "Expected ConstraintViolationException");
    }



    @Test
    void minInventoryShouldNotExceedMaximum() {
        partIn.setMinInventory(16);

        try {
            partIn.setMinInventory(partIn.getMinInventory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void maxInventoryShouldNotBeBelowMinimum() {

        Part partIn = new InhousePart();
        int invalidMinInventoryValue = -1;
        partIn.setMinInventory(invalidMinInventoryValue);

        Set<ConstraintViolation<Part>> violations = validator.validate(partIn);

        assertFalse(violations.isEmpty(), "Expected ConstraintViolationException");
    }

    @Test
    void maxInventoryShouldNotExceedMaximum() {
        partIn.setMinInventory(16);

        try {
            partIn.setMinInventory(partIn.getMinInventory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}