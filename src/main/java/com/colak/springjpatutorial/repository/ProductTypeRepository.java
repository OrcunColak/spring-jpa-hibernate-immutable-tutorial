package com.colak.springjpatutorial.repository;

import com.colak.springjpatutorial.jpa.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
