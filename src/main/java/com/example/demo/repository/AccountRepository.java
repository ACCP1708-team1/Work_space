package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Account;

public interface AccountRepository extends CrudRepository<Account,Integer>{
	@Query("from Account where username=:username")
	public Account findWithUsername(@Param("username") String username);
//	@Query("from register where lastname=:user")
//	public List<Account> findWithLastname(@Param("last") String last);
}
