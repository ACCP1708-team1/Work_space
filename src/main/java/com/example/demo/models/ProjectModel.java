package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Project;
import com.example.demo.repository.ProjectRepository;

public class ProjectModel implements ModelInteface<Project>{
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Project findById(int id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}

	@Override
	public Project save(Project k) {
		// TODO Auto-generated method stub
		return projectRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

}
