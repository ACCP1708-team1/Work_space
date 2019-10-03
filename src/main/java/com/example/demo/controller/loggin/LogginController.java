package com.example.demo.controller.loggin;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entities.Account;
import com.example.demo.models.AccountModel;

@Controller
@RequestMapping(value = "user")
public class LogginController {
	private AccountModel accountModel = new AccountModel();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		return "user.login";

	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String login(ModelMap modelMap, @ModelAttribute Account account) {

		Account accountDB = accountModel.findWithUsername(account.getUsername());
		if (accountDB != null) {
			AccountModel accountModel = new AccountModel();
			account = accountModel.enCodePassword(account);
			if (accountModel.checkPassword(account, accountDB)) {
				return "default.home";
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
	public String register(ModelMap modelMap, HttpSession session, @RequestBody Account account,
			@PathVariable("repassword") String repassword) throws Exception {

		Account accountDB = accountModel.findWithUsername(account.getUsername());
		if (accountDB != null) {
			return "user.register";
		} else {
			accountDB = accountModel.enCodePassword(account);
			Account newAccount = accountModel.save(account);
			if (newAccount != null) {
				newAccount.setPassword("");
			}
			else {
				throw new Exception("Khong the them moi tai khoan");
			}
			session.setAttribute("user", account);
			return "default.home";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "login.logout";

	}
}
