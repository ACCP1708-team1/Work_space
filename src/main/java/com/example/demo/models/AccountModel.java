package com.example.demo.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repository.AccountRepository;
@Service
public class AccountModel implements ModelInteface<Account>{
	private AccountRepository accountRepository;
	public Account enCodePassword(Account account) {
		if (account.getPassword() != "") {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] hashInBytes = md.digest(account.getPassword().getBytes(StandardCharsets.UTF_8));
				String newPassword = DatatypeConverter.printHexBinary(hashInBytes).toUpperCase();
				account.setPassword(newPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return account;
	}
	public boolean checkPassword(Account account,Account accountdb) {
		return accountdb.getPassword().toUpperCase().equalsIgnoreCase(account.getPassword().toUpperCase());
			
	}
	@Override
	public Account findById(int id) {
		Account account=accountRepository.findById(id).get();
		return account;
	}
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		List<Account> accounts=(List<Account>) accountRepository.findAll();
		return accounts;
	}
	@Override
	public Account save(Account k) {
		// TODO Auto-generated method stub
		k=accountRepository.save(k);
		return k;
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}
	public Account findWithUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findWithUsername(username);
	}
	@Autowired
	public AccountModel(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	
}
