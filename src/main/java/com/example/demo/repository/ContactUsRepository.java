package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ContactUs;

public interface ContactUsRepository extends CrudRepository<ContactUs, Integer>{
	@Query(nativeQuery = true,value = "select *from contact_us where status=1 ORDER BY id DESC LIMIT 1")
	public ContactUs newContact();

	@Override
	@Query("from ContactUs where status=1")
	Optional<ContactUs> findById(Integer id);

	@Override
	@Query("from ContactUs where status=1")
	Iterable<ContactUs> findAll();
	
}
