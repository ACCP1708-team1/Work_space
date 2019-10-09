package com.example.demo.controller.loggin;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entities.Account;
import com.example.demo.models.AccountModel;
import com.example.demo.models.AccountRoleModel;

@Controller
@RequestMapping(value = "user")
public class LogginController {
	@Autowired
	private AccountModel accountModel;
	@Autowired
	AccountRoleModel accountRoleModel;
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		return "user.login";

	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String login(ModelMap modelMap,HttpSession session,@ModelAttribute Account account) {

		Account accountDB = accountModel.findWithUsername(account.getUsername());
		if (accountDB != null) {
			if (accountModel.checkPassword(account, accountDB)) {
				account.setPassword("");
				session.setAttribute("user", accountDB);
				return "redirect:/home";
			}
		}
		return "user.login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.addAttribute("account", account);
		modelMap.addAttribute("repassword","");
		return "user.register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8" )
	public String register(ModelMap modelMap, HttpSession session, @ModelAttribute Account account,
			@ModelAttribute String repassword)throws Exception {

		Account accountDB = accountModel.findWithUsername(account.getUsername());
		if (accountDB != null) {
			return "user.register";
		} else {
			account = accountModel.enCodePassword(account);
			account.setAccountRole(accountRoleModel.findById(1));
			account.setAvatar("");
			account.setCreatedate(new Date());
			account.setStatus((byte) 1);
			Account newAccount = accountModel.save(account);
			if (newAccount != null) {
				newAccount.setPassword("");
			}
			else {
				throw new Exception("Khong the them moi tai khoan");
			}
			session.setAttribute("user", newAccount);
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/home";

	}
}
