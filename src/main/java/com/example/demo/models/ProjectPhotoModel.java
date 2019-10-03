package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.ProjectPhoto;
import com.example.demo.repository.ProjectPhotoRepository;

public class ProjectPhotoModel implements ModelInteface<ProjectPhoto>{
	@Autowired
	private ProjectPhotoRepository projectPhotoRepository;
	@Override
	public List<ProjectPhoto> findAll() {
		// TODO Auto-generated method stub
		return (List<ProjectPhoto>) projectPhotoRepository.findAll();
	}

	@Override
	public ProjectPhoto findById(int id) {
		// TODO Auto-generated method stub
		return projectPhotoRepository.findById(id).get();
	}

	@Override
	public ProjectPhoto save(ProjectPhoto k) {
		// TODO Auto-generated method stub
		return projectPhotoRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		projectPhotoRepository.deleteById(id);
	}

}
