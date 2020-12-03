package com.audittest.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface ProductRepository extends JpaRepository<Product, Long> {
}
