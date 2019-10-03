package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ServicePhoto;

public interface ServicerPhotoRepository extends CrudRepository<ServicePhoto, Integer>{

	@Override
	@Query("from ServicePhoto where status=1")
	Optional<ServicePhoto> findById(Integer id);

	@Override
	@Query("from ServicePhoto where status=1")
	Iterable<ServicePhoto> findAll();
	
}
