package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
class OutsourcedPartTest {

    OutsourcedPart op;

    @BeforeEach
    void setUp() {
        this.op = new OutsourcedPart();
    }

    @Test
    void getCompanyName() {
        final String name="test company name";
        this.op.setCompanyName(name);
        assertEquals(name, this.op.getCompanyName());
    }

    @Test
    void setCompanyName() {
        final String name="test company name";
        this.op.setCompanyName(name);
        assertEquals(name, this.op.getCompanyName());
    }
}