package com.colak.springjpatutorial.service;

import com.colak.springjpatutorial.jpa.ProductType;
import com.colak.springjpatutorial.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Transactional
    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Transactional(readOnly = true)
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        productTypeRepository.deleteById(id);
    }

}
