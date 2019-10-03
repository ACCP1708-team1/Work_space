package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Servicer;
import com.example.demo.repository.ServicerRepository;

public class ServiceModel implements ModelInteface<Servicer>{
	@Autowired
	private ServicerRepository servicerRepository;
	@Override
	public List<Servicer> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicer>) servicerRepository.findAll();
	}

	@Override
	public Servicer findById(int id) {
		// TODO Auto-generated method stub
		return servicerRepository.findById(id).get();
	}

	@Override
	public Servicer save(Servicer k) {
		// TODO Auto-generated method stub
		return servicerRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		servicerRepository.deleteById(id);
	}

}
