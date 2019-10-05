package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Account;

public interface AccountRepository extends CrudRepository<Account,Integer>{
	@Query("from Account where username=:username")
	public Account findWithUsername(@Param("username") String username);
	@Override
	@Query("from Account where id=:id and status=1") 
	Optional<Account> findById(@Param("id") Integer id);
	@Override
	@Query("from Account where status=1") 
	Iterable<Account> findAll();

}
