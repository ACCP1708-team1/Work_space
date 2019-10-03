package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ProjectPhoto;
import com.example.demo.entities.ProjectPhoto;

public interface ProjectPhotoRepository extends CrudRepository<ProjectPhoto, Integer>{

	@Override
	@Query("from ProjectPhoto where status=1")
	Optional<ProjectPhoto> findById(Integer id);

	@Override
	@Query("from ProjectPhoto where status=1")
	Iterable<ProjectPhoto> findAll();
	
}
