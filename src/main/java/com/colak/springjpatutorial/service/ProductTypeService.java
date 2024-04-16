package com.colak.springjpatutorial.service;

import com.colak.springjpatutorial.jpa.ProductType;
import com.colak.springjpatutorial.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Transactional
    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Transactional
    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

}
