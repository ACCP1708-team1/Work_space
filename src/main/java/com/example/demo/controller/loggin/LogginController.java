package com.example.demo.controller.loggin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entities.Account;
import com.example.demo.repository.AccountRepository;

@Controller
@RequestMapping(value = "user")
public class LogginController {
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		return "user.login";

	}

	@RequestMapping(value = "login", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public String login(ModelMap modelMap, @ModelAttribute Account account) {

		Account accountDB = accountRepository.findWithUsername(account.getUsername());
		if (accountDB!=null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] hashInBytes = md.digest("12345".getBytes(StandardCharsets.UTF_8));
				String newPassword = DatatypeConverter.printHexBinary(hashInBytes).toUpperCase();
				System.out.println(newPassword);
				if (accountDB.getPassword().toUpperCase().equalsIgnoreCase(newPassword.toUpperCase())) {
					return "default.home";
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "user.login";

	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.addAttribute("account", account);
		return "user.register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(ModelMap modelMap,HttpSession session, @RequestBody Account account,@PathVariable("repassword") String repassword) {

		Account accountDB = accountRepository.findWithUsername(account.getUsername());
		if (accountDB != null) {
			return "user.register";
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] hashInBytes = md.digest(account.getPassword().getBytes(StandardCharsets.UTF_8));
				String newPassword = DatatypeConverter.printHexBinary(hashInBytes).toUpperCase();
				Account newAccount=accountRepository.save(account);
				if(newAccount!=null) {
					newAccount.setPassword("");
				}
				System.out.println(newPassword);
				session.setAttribute("user", account);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "default.home";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "login.logout";

	}
}
