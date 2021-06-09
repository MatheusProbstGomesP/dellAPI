package com.residencia.dell.repositories;

import com.residencia.dell.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
}
