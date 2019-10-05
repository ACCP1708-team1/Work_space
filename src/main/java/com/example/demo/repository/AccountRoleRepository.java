package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.AccountRole;

public interface AccountRoleRepository extends CrudRepository<AccountRole,Integer>{
//	@Query("from register where username=:user")
//	public Account findWithUsername(@Param("user") String user);
//	@Query("from register where lastname=:user")
//	public List<Account> findWithLastname(@Param("last") String last);
}
