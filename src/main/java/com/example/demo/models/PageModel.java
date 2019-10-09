package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Page;
import com.example.demo.repository.PageRepository;

public class PageModel implements ModelInteface<Page>{
	@Autowired
	private PageRepository pageRepository;
	@Override
	public List<Page> findAll() {
		// TODO Auto-generated method stub
		return (List<Page>) pageRepository.findAll();
	}

	@Override
	public Page findById(int id) {
		// TODO Auto-generated method stub
		return pageRepository.findById(id).get();
	}

	@Override
	public Page save(Page k) {
		// TODO Auto-generated method stub
		return pageRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		pageRepository.deleteById(id);
	}

	public PageModel() {
		super();
	}
	
}
