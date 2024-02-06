package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
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
public class PartServiceImpl implements PartService{
        private final PartRepository partRepository;

        @Autowired

    public PartServiceImpl(final PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return (List<Part>) this.partRepository.findAll();
    }
    public List<Part> listAll(final String keyword){
        if(null != keyword){
            return this.partRepository.search(keyword);
        }
        return (List<Part>) this.partRepository.findAll();
    }
    @Override
    public Part findById(final int theId) {
        final Long theIdl=(long)theId;
        final Optional<Part> result = this.partRepository.findById(theIdl);

        Part thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the part id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return thePart;
    }

    @Override
    public void save(final Part thePart) {
        this.partRepository.save(thePart);

    }

    @Override
    public void deleteById(final int theId) {
        final Long theIdl=(long)theId;
        this.partRepository.deleteById(theIdl);
    }
}
