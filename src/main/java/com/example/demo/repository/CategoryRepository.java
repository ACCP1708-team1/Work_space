package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

	@Override
	@Query("from Category where status=1")
	Optional<Category> findById(Integer id);

	@Override
	@Query("from Category where status=1")
	Iterable<Category> findAll();
	
}
