package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Faq;

public interface FaqRepository extends CrudRepository<Faq, Integer>{

	@Override
	@Query("from Faq where id=:id and status=1")
	Optional<Faq> findById(@Param("id") Integer id);

	@Override
	@Query("from Faq where status=1")
	Iterable<Faq> findAll();
	
}
