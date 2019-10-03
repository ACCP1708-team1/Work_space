package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;

public class CategoryModel implements ModelInteface<Category>{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category save(Category k) {
		// TODO Auto-generated method stub
		return categoryRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

}
