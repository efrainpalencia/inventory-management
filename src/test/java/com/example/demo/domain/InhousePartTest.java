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
 * Time: 3:45 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class InhousePartTest {
    InhousePart ip;
    @BeforeEach
    void setUp() {
        this.ip = new InhousePart();
    }

    @Test
    void getPartId() {
        final int idValue=4;
        this.ip.setPartId(idValue);
        assertEquals(this.ip.getPartId(), idValue);
    }

    @Test
    void setPartId() {
        final int idValue=4;
        this.ip.setPartId(idValue);
        assertEquals(this.ip.getPartId(), idValue);
    }
}