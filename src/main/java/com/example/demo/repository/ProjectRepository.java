package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	@Query(value = "from Project where projectStatus.id=:id_status_project and status=1")
	public List<Project> findByIdStatus(@Param("id_status_project") int idProjectStatus);
}
