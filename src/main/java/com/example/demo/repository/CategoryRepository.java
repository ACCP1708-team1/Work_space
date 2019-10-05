package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
