package com.example.demo.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Account;
import com.example.demo.models.AccountModel;

@Controller
@RequestMapping(value = "/userProfile")
public class UserProfileController {
	@Autowired
	AccountModel accountModel;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String userProfile(ModelMap modelMap, HttpSession session) {
		Account account = (Account) session.getAttribute("user");
		modelMap.put("account", account);
		return "userProfile.profile";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String userProfileEdit(ModelMap modelMap, HttpSession session) {
		Account account = (Account) session.getAttribute("user");
		modelMap.put("account", account);
		return "userProfile.editProfile";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String changerProfile(ModelMap modelMap, HttpSession session, @ModelAttribute Account account,
			@RequestParam String repassword, @RequestParam String email) {

		//Account user = (Account) session.getAttribute("user");
		Account accountdb = accountModel.findById(account.getIdAccount());
		if (accountModel.checkPassword(account, accountdb)) {
			account.setPassword(accountdb.getPassword());
			accountModel.save(account);
			account.setPassword("");
			session.removeAttribute("user");
			session.setAttribute("user", account);
			return "redirect:/";
		} else {

			return "userProfile.editProfile";
		}
	}

	@RequestMapping(value = "/changerPassword")
	public String changerPassword(ModelMap modelMap, HttpSession session) {
		Account user = (Account) session.getAttribute("user");
		modelMap.addAttribute("account", user);
		return "userProfile.changerPassword";
	}

	@RequestMapping(value = "/changerPassword", method = RequestMethod.POST)
	public String changerPassword(ModelMap modelMap, HttpSession session, @RequestParam String newpassword,
			@ModelAttribute Account account) {
//		Account user = (Account) session.getAttribute("user");
		Account accountdb = accountModel.findById(account.getIdAccount());
		if (accountModel.checkPassword(account, accountdb)) {
			accountdb.setPassword(newpassword);
			accountdb = accountModel.enCodePassword(accountdb);
			accountModel.save(accountdb);
			accountdb.setPassword("");
			session.removeAttribute("user");
			session.setAttribute("user", accountdb);
			return "redirect:";
		} else {

			return "userProfile.changerPassword";
		}
	}
}
