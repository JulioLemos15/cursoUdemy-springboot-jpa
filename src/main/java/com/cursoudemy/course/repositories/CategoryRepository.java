package com.cursoudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
