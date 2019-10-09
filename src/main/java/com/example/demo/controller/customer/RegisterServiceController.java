package com.example.demo.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.Servicer;
import com.example.demo.models.AccountModel;
import com.example.demo.models.InvoiceModel;
import com.example.demo.models.ServiceModel;
@Controller
@RequestMapping("customer/registerService")
public class RegisterServiceController {
	@Autowired
	AccountModel accountModel;
	@Autowired
	InvoiceModel invoiceModel;
	@Autowired
	ServiceModel serviceModel;

	@RequestMapping(value = "/register/{id_service}", method = RequestMethod.GET)
	public String registerService(ModelMap modelMap, @PathVariable("id_service") int id_service, HttpSession session) {
		Account user = (Account) session.getAttribute("user");
		Invoice invoice = new Invoice();
		Servicer servicer = serviceModel.findById(id_service);
		List<Servicer> services=serviceModel.findAllByCategoryId(servicer.getCategory().getId());
		modelMap.addAttribute("service", servicer);
		modelMap.addAttribute("services", services);
		modelMap.addAttribute("invoice", invoice);
		//modelMap.addAttribute("category", servicer.getCategory());
		return "customer.registerService.register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerService(ModelMap modelMap, HttpSession session, @ModelAttribute Invoice invoice,
			@ModelAttribute List<Integer> listId) {
		Account user = (Account) session.getAttribute("user");
		invoiceModel.registerService(user.getIdAccount(), listId, invoice);
		return "customer.registerService.register";
	}
}
