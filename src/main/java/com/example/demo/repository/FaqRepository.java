package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Faq;

public interface FaqRepository extends CrudRepository<Faq, Integer>{

	@Override
	@Query("from Faq where status=1")
	Optional<Faq> findById(Integer id);

	@Override
	@Query("from Faq where status=1")
	Iterable<Faq> findAll();
	
}
