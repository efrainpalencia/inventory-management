package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
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
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Product findById(final int theId) {
        final Long theIdl=(long)theId;
        final Optional<Product> result = this.productRepository.findById(theIdl);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(final Product theProduct) {
        this.productRepository.save(theProduct);

    }

    @Override
    public void deleteById(final int theId) {
        final Long theIdl=(long)theId;
        this.productRepository.deleteById(theIdl);
    }
    public List<Product> listAll(final String keyword){
        if(null != keyword){
            return this.productRepository.search(keyword);
        }
        return (List<Product>) this.productRepository.findAll();
    }
}
