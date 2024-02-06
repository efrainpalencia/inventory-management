package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.PartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.service
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:36 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class InhousePartServiceTest {
    InhousePartRepository inhousePartRepository;
    InhousePartService inhousePartService;
    @BeforeEach
    void setUp() {
        this.inhousePartRepository =mock(InhousePartRepository.class);
        this.inhousePartService =new InhousePartServiceImpl(this.inhousePartRepository);
    }

    @Test
    void findAll() {
        final InhousePart part=new InhousePart();
        final List partData=new ArrayList();
        partData.add(part);
        when(this.inhousePartRepository.findAll()).thenReturn(partData);
        final List<InhousePart> parts= this.inhousePartService.findAll();
        assertEquals(partData.size(),1);
    }
}