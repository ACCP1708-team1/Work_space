package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

	@Override
	@Query("from Category where id=:id and status=1")
	Optional<Category> findById(@Param("id") Integer id);

	@Override
	@Query("from Category where status=1")
	Iterable<Category> findAll();
	
}
