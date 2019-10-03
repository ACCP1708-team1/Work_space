package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.AccountRole;
import com.example.demo.repository.AccountRoleRepository;

public class AccountRoleModel implements ModelInteface<AccountRole>{
	@Autowired
	private AccountRoleRepository accountRoleRepository;
	@Override
	public List<AccountRole> findAll() {
		// TODO Auto-generated method stub
		return (List<AccountRole>) accountRoleRepository.findAll();
	}

	@Override
	public AccountRole findById(int id) {
		// TODO Auto-generated method stub
		return accountRoleRepository.findById(id).get();
	}

	@Override
	public AccountRole save(AccountRole k) {
		// TODO Auto-generated method stub
		return accountRoleRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		accountRoleRepository.deleteById(id);
	}

}
