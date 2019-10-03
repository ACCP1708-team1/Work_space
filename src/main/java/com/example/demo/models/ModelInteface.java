package com.example.demo.models;

import java.util.List;

public interface ModelInteface <K> {
	public List<K> findAll();
	public K findById(int id);
	public K save(K k);
	public void deleteById(int id);
}
