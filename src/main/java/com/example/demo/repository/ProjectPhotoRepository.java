package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ProjectPhoto;

public interface ProjectPhotoRepository extends CrudRepository<ProjectPhoto, Integer>{

	@Override
	@Query("from ProjectPhoto where id=:id and status=1")
	Optional<ProjectPhoto> findById(@Param("id") Integer id);

	@Override
	@Query("from ProjectPhoto where status=1")
	Iterable<ProjectPhoto> findAll();
	
}
