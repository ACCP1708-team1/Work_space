package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ProjectStatus;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus, Integer>{

}
