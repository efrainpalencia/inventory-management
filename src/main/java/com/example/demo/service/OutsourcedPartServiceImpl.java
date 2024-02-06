package com.example.demo.service;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.repositories.OutsourcedPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class OutsourcedPartServiceImpl implements OutsourcedPartService{
    private final OutsourcedPartRepository partRepository;

    @Autowired
    public OutsourcedPartServiceImpl(final OutsourcedPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<OutsourcedPart> findAll() {
        return (List<OutsourcedPart>) this.partRepository.findAll();
    }

    @Override
    public OutsourcedPart findById(final int theId) {
        final Long theIdl=(long)theId;
        final Optional<OutsourcedPart> result = this.partRepository.findById(theIdl);

        OutsourcedPart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(final OutsourcedPart thePart) {
        this.partRepository.save(thePart);

    }

    @Override
    public void deleteById(final int theId) {
        final Long theIdl=(long)theId;
        this.partRepository.deleteById(theIdl);
    }

}
