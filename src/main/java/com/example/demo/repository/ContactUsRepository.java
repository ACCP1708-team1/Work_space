package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ContactUs;

public interface ContactUsRepository extends CrudRepository<ContactUs, Integer>{
	@Query(nativeQuery = true,value = "select *from contact_us where status=1 ORDER BY id DESC LIMIT 1")
	public ContactUs newContact();
}
