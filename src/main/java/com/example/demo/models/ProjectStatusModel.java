package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProjectStatus;
import com.example.demo.repository.ProjectStatusRepository;

@Service
public class ProjectStatusModel implements ModelInteface<ProjectStatus>{
	//@Autowired
	private ProjectStatusRepository projectStatusRepository;
	@Override
	public List<ProjectStatus> findAll() {
		// TODO Auto-generated method stub
		return (List<ProjectStatus>) projectStatusRepository.findAll();
	}

	@Override
	public ProjectStatus findById(int id) {
		// TODO Auto-generated method stub
		return projectStatusRepository.findById(id).get();
	}

	@Override
	public ProjectStatus save(ProjectStatus k) {
		// TODO Auto-generated method stub
		return projectStatusRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		projectStatusRepository.deleteById(id);
	}
	@Autowired
	public ProjectStatusModel(ProjectStatusRepository projectStatusRepository) {
		super();
		this.projectStatusRepository = projectStatusRepository;
	}
	
	
}
