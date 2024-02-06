package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: demo
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 4/28/2022
 * Time: 4:01 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class ProductTest {
    Product product;
    @BeforeEach
    public void setUp(){
        this.product =new Product();
    }
    @Test
    void getId() {
        final Long idValue=4L;
        this.product.setId(idValue);
        assertEquals(this.product.getId(), idValue);
    }

    @Test
    void setId() {
        final Long idValue=4L;
        this.product.setId(idValue);
        assertEquals(this.product.getId(), idValue);
    }

    @Test
    void getName() {
        final String name="test product";
        this.product.setName(name);
        assertEquals(name, this.product.getName());
    }

    @Test
    void setName() {
        final String name="test product";
        this.product.setName(name);
        assertEquals(name, this.product.getName());
    }

    @Test
    void getPrice() {
        final double price=1.0;
        this.product.setPrice(price);
        assertEquals(price, this.product.getPrice());
    }

    @Test
    void setPrice() {
        final double price=1.0;
        this.product.setPrice(price);
        assertEquals(price, this.product.getPrice());
    }

    @Test
    void getInv() {
        final int inv=5;
        this.product.setInv(inv);
        assertEquals(inv, this.product.getInv());
    }

    @Test
    void setInv() {
        final int inv=5;
        this.product.setInv(inv);
        assertEquals(inv, this.product.getInv());
    }

    @Test
    void getParts() {
        final Part part1 = new OutsourcedPart();
        final Part part2 = new InhousePart();
        final Set<Part> myParts= new HashSet<>();
        myParts.add(part1);
        myParts.add(part2);
        this.product.setParts(myParts);
        assertEquals(myParts, this.product.getParts());
    }

    @Test
    void setParts() {
        final Part part1 = new OutsourcedPart();
        final Part part2 = new InhousePart();
        final Set<Part> myParts= new HashSet<>();
        myParts.add(part1);
        myParts.add(part2);
        this.product.setParts(myParts);
        assertEquals(myParts, this.product.getParts());
    }

    @Test
    void testToString() {
        final String name="test product";
        this.product.setName(name);
        assertEquals(name, this.product.toString());
    }

    @Test
    void testEquals() {
        this.product.setId(1L);
        final Product newProduct= new Product();
        newProduct.setId(1L);
        assertEquals(this.product,newProduct);
    }

    @Test
    void testHashCode() {
        this.product.setId(1L);
        final Product newProduct= new Product();
        newProduct.setId(1L);
        assertEquals(this.product.hashCode(),newProduct.hashCode());
    }
}