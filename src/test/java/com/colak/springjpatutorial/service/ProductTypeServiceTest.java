package com.colak.springjpatutorial.service;

import com.colak.springjpatutorial.jpa.ProductType;
import com.colak.springjpatutorial.repository.ProductTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTypeServiceTest {

    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Test
    void save() {
        ProductType productType = new ProductType();
        productType.setName("product 1");
        ProductType saved = productTypeRepository.save(productType);

        Optional<ProductType> byId = productTypeRepository.findById(saved.getId());
        assertThat(byId).isPresent();
        assertThat(byId.get().getName()).isEqualTo("product 1");

        // When attempting to change and save an ProductType object annotated as @Immutable, Hibernate ignores these changes.
        // No error is thrown; the changes simply won't be saved in the database.
        productType = new ProductType();
        productType.setId(saved.getId());
        productType.setName("product 2");
        productTypeRepository.save(productType);

        byId = productTypeRepository.findById(saved.getId());
        assertThat(byId).isPresent();
        assertThat(byId.get().getName()).isEqualTo("product 1");

        // In the case of an attempt to delete, despite the entity’s immutability, the deletion operation will be successful.
        // The @Immutable annotation does not affect deletion operations.
        productTypeRepository.deleteById(saved.getId());
        byId = productTypeRepository.findById(saved.getId());
        assertThat(byId).isEmpty();
    }
}