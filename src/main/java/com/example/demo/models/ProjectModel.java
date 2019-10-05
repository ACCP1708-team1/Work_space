package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Project;
import com.example.demo.repository.ProjectRepository;
@Service
public class ProjectModel implements ModelInteface<Project>{
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

	@Autowired
	public ProjectModel(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}
	
}
