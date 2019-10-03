package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.AccountRole;

public interface AccountRoleRepository extends CrudRepository<AccountRole,Integer>{

	@Override
	@Query("from AccountRole where status=1")
	Optional<AccountRole> findById(Integer id);
	@Override
	@Query("from AccountRole where status=1")
	Iterable<AccountRole> findAll();
	
}
