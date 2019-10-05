package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.InvoiceDetail;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Integer>{

	@Override
	@Query("from InvoiceDetail where id=:id and status=1")
	Optional<InvoiceDetail> findById(@Param("id") Integer id);

	@Override
	@Query("from InvoiceDetail where status=1")
	Iterable<InvoiceDetail> findAll();
	
}
