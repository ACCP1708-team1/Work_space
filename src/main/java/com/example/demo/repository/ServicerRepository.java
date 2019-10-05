package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Servicer;

public interface ServicerRepository extends CrudRepository<Servicer, Integer>{
	@Query("from Servicer where category.id=:id_category and status=1")
	public Iterable<Servicer> findAllByCategoryId(@Param("id_category") int id_category);

	@Override
	@Query("from Servicer where id=:id and status=1")
	Optional<Servicer> findById(@Param("id") Integer id);

	@Override
	@Query("from Servicer where status=1")
	Iterable<Servicer> findAll();
	
}
