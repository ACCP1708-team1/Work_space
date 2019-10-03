package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.ContactUs;
import com.example.demo.repository.ContactUsRepository;

public class ContactUsModel implements ModelInteface<ContactUs>{
	@Autowired
	private ContactUsRepository contactUsRepository;
	@Override
	public List<ContactUs> findAll() {
		// TODO Auto-generated method stub
		return (List<ContactUs>) contactUsRepository.findAll();
	}

	@Override
	public ContactUs findById(int id) {
		// TODO Auto-generated method stub
		return contactUsRepository.findById(id).get();
	}

	@Override
	public ContactUs save(ContactUs k) {
		// TODO Auto-generated method stub
		return contactUsRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		contactUsRepository.deleteById(id);
	}

}
