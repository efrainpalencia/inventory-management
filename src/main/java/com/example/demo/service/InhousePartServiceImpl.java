package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.repositories.InhousePartRepository;
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
public class InhousePartServiceImpl implements InhousePartService {
    private final InhousePartRepository partRepository;

    @Autowired
    public InhousePartServiceImpl(final InhousePartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<InhousePart> findAll() {
        return (List<InhousePart>) this.partRepository.findAll();
    }

    @Override
    public InhousePart findById(final int theId) {
        final Long theIdl=(long)theId;
        final Optional<InhousePart> result = this.partRepository.findById(theIdl);

        InhousePart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the InhousePart id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(final InhousePart thePart) {
        this.partRepository.save(thePart);

    }

    @Override
    public void deleteById(final int theId) {
        final Long theIdl=(long)theId;
        this.partRepository.deleteById(theIdl);
    }

}
