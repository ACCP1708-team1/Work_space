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
@RequestMapping("customer/invoice")
public class InvoiceController {
	@Autowired
	AccountModel accountModel;
	@Autowired
	InvoiceModel invoiceModel;
	@RequestMapping(value = "/allUser",method = RequestMethod.GET)
	public String allForUser(ModelMap modelMap,HttpSession session) {
		Account user=(Account) session.getAttribute("user");
		List<Invoice> invoices=invoiceModel.findAllForUser(user.getIdAccount());
		modelMap.addAttribute("invoices",invoices);
		return "customer.invoice.all";
	}
	@RequestMapping(value = "/findInvoice/{id}",method = RequestMethod.GET)
	public String findInvoiceById(ModelMap modelMap,@PathVariable("id") int id) {
		Invoice invoice=invoiceModel.findById(id);
		modelMap.addAttribute("invoice",invoice);
		return "customer.invoice.byId";
	}
	@RequestMapping(value = "/findComplete",method = RequestMethod.GET)
	public String findCompleteForUser(ModelMap modelMap,HttpSession session) {
		Account user=(Account) session.getAttribute("user");
		List<Invoice> invoices=invoiceModel.findCompleteForUser(user.getIdAccount());
		modelMap.addAttribute("invoices",invoices);
		return "customer.invoice.complete";
	}
	@RequestMapping(value = "/findPaying",method = RequestMethod.GET)
	public String findPayingForUser(ModelMap modelMap,HttpSession session) {
		Account user=(Account) session.getAttribute("user");
		List<Invoice> invoices=invoiceModel.findPayingForUser(user.getIdAccount());
		modelMap.addAttribute("invoices",invoices);
		return "customer.invoice.paying";
	}
	@RequestMapping(value = "/findExpired",method = RequestMethod.GET)
	public String findExpiredForUser(ModelMap modelMap,HttpSession session) {
		Account user=(Account) session.getAttribute("user");
		List<Invoice> invoices=invoiceModel.findExpiredForUser(user.getIdAccount());
		modelMap.addAttribute("invoices",invoices);
		return "customer.invoice.expired";
	}
}
