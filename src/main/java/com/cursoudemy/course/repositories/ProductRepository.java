package com.cursoudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
