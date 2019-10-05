package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ProjectStatus;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus, Integer>{

	@Override
	@Query("from ProjectStatus where id=:id and status=1")
	Optional<ProjectStatus> findById(@Param("id") Integer id);

	@Override
	@Query("from ProjectStatus where status=1")
	Iterable<ProjectStatus> findAll();
	
}
