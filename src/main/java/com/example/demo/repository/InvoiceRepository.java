package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

	@Override
	@Query("from Invoice where status=1")
	Optional<Invoice> findById(Integer id);

	@Override
	@Query("from Invoice where status=1")
	Iterable<Invoice> findAll();
	
}
