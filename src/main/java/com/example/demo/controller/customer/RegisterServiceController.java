package com.example.demo.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Account;
import com.example.demo.entities.RegisterService;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RegisterServiceRepository;
import com.example.demo.repository.ServicerRepository;

@Controller
@RequestMapping(value = "customer/registerService")
public class RegisterServiceController {
	@Autowired
	private RegisterServiceRepository registerServiceRepository ;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ServicerRepository servicerRepository;
	
	@RequestMapping(value = "/forUser",method = RequestMethod.GET)
	public String findAllByUserId(ModelMap modelMap,HttpServletRequest httpServletRequest) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		Iterable<RegisterService> registerServices=registerServiceRepository.findAllByUserId(user.getIdAccount());
		modelMap.addAttribute(registerServices);
		return "customer.registerService-AccountId";
	}

	@RequestMapping(value = "/forUserByAllStatus",method = RequestMethod.GET)
	public String findAllForUserByStatus(ModelMap modelMap,HttpServletRequest httpServletRequest) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		Iterable<RegisterService> registerServicesOnGoing=registerServiceRepository.findAllByUserOnGoing(user.getIdAccount());
		Iterable<RegisterService> registerServicesUpComing=registerServiceRepository.findAllByUserUpComing(user.getIdAccount());
		Iterable<RegisterService> registerServicesAccomplished=registerServiceRepository.findAllByAccomplished(user.getIdAccount());
		modelMap.addAttribute("registerServicesOnGoing",registerServicesOnGoing);
		modelMap.addAttribute("registerServicesUpComing",registerServicesUpComing);
		modelMap.addAttribute("registerServicesAccomplished",registerServicesAccomplished);
		return "customer.registerService-allStatus";
	}
	@RequestMapping(value = "/forUserOnGoing",method = RequestMethod.GET)
	public String findAllForUserOnGoing(HttpServletRequest httpServletRequest,ModelMap modelMap) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		Iterable<RegisterService> registerServicesOnGoing=registerServiceRepository.findAllByUserOnGoing(user.getIdAccount());
		modelMap.addAttribute("registerServicesOnGoing",registerServicesOnGoing);
		return "customer.registerService-onGoing";
	}
	@RequestMapping(value = "/forUserUpComing",method = RequestMethod.GET)
	public String findAllForUserUpComing(HttpServletRequest httpServletRequest,ModelMap modelMap) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		Iterable<RegisterService> registerServicesUpComing=registerServiceRepository.findAllByUserUpComing(user.getIdAccount());
		modelMap.addAttribute("registerServicesUpComing",registerServicesUpComing);
		return "customer.registerService-UpComing";
	}
	@RequestMapping(value = "/forUserAccomplished",method = RequestMethod.GET)
	public String findAllForUserAccomplished(HttpServletRequest httpServletRequest,ModelMap modelMap) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		Iterable<RegisterService> registerServicesAccomplished=registerServiceRepository.findAllByAccomplished(user.getIdAccount());
		modelMap.addAttribute("registerServicesAccomplished",registerServicesAccomplished);
		return "customer.registerService-Accomplished";
	}
	@RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
	public String findById(HttpServletRequest httpServletRequest,ModelMap modelMap,@PathVariable("id") int id) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		RegisterService registerService=registerServiceRepository.findById(id).get();
		// Check if registerService belongs to account
		if(user.getIdAccount()==registerService.getAccount().getIdAccount()) {
			return "customer.registerService-ById";
		}
		else {
			return "customer.registerService-AccountId";
		}
	}
	@RequestMapping (value = "/addRegisterServiceForUser/{id_servicer}",method = RequestMethod.GET)
	public String addRegisterService(ModelMap modelMap,HttpServletRequest httpServletRequest,@PathVariable("is_servicer") int id_service) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		RegisterService registerService=new RegisterService();
		registerService.setAccount(accountRepository.findById(user.getIdAccount()).get());
		registerService.setServicer(servicerRepository.findById(id_service).get());
		modelMap.addAttribute("registerService",registerService);
		return "default.addRegisterService";
	}
	
	@RequestMapping(value = "/addRegisterSeriverForUser",method = RequestMethod.POST)
	public String addRegisterService(ModelMap modelMap,HttpServletRequest httpServletRequest,@RequestBody RegisterService registerService) {
		Account user=(Account)httpServletRequest.getSession().getAttribute("user");
		//Get user from db because user session don't have password
		registerService.setAccount(accountRepository.findById(user.getIdAccount()).get());
		registerService.setPriceDetail(0);
		try {
			registerServiceRepository.save(registerService);
		}catch(Exception e) {
			
		}
		return "default.addRegisterService";
	}
	
}
