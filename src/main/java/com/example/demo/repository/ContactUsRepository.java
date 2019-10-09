package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ContactUs;

public interface ContactUsRepository extends CrudRepository<ContactUs, Integer>{
	@Query(nativeQuery = true,value = "select *from contact_us where status=1 ORDER BY id DESC LIMIT 1")
	public ContactUs newContact();

	@Query("from ContactUs where id=:id and status=1")
	public ContactUs findByIdStatus(@Param("id") Integer id);

	@Query("from ContactUs where status=1")
	public List<ContactUs> findAllStatus();
	
}
