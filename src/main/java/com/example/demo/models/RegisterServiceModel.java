package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.RegisterService;
import com.example.demo.repository.RegisterServiceRepository;

public class RegisterServiceModel implements ModelInteface<RegisterService>{
	@Autowired
	private RegisterServiceRepository registerServiceRepository;
	@Override
	public List<RegisterService> findAll() {
		// TODO Auto-generated method stub
		return (List<RegisterService>) registerServiceRepository.findAll();
	}

	@Override
	public RegisterService findById(int id) {
		// TODO Auto-generated method stub
		return registerServiceRepository.findById(id).get();
	}

	@Override
	public RegisterService save(RegisterService k) {
		// TODO Auto-generated method stub
		return registerServiceRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		registerServiceRepository.deleteById(id);
	}

}
