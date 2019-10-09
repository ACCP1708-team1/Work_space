package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.ServicePhoto;
import com.example.demo.repository.ServicerPhotoRepository;

public class ServicePhotoModel implements ModelInteface<ServicePhoto>{
	@Autowired
	private ServicerPhotoRepository servicePhotoRepository;
	@Override
	public List<ServicePhoto> findAll() {
		// TODO Auto-generated method stub
		return (List<ServicePhoto>) servicePhotoRepository.findAll();
	}

	@Override
	public ServicePhoto findById(int id) {
		// TODO Auto-generated method stub
		return servicePhotoRepository.findById(id).get();
	}

	@Override
	public ServicePhoto save(ServicePhoto k) {
		// TODO Auto-generated method stub
		return servicePhotoRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		servicePhotoRepository.deleteById(id);
	}

	public ServicePhotoModel() {
		super();
	}
	
}	
