package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Page;

public interface PageRepository extends CrudRepository<Page, Integer>{

	@Override
	@Query("from Page where id=:id and  status=1")
	Optional<Page> findById(@Param("id") Integer id);

	@Override
	@Query("from Page where status=1")
	Iterable<Page> findAll();
	
}
