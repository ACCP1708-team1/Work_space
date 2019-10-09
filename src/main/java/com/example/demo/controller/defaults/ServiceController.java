package com.example.demo.controller.defaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Servicer;
import com.example.demo.models.LoadDataTemplate;
import com.example.demo.repository.ServicerRepository;

@Controller
@RequestMapping(value = "service")
public class ServiceController {
	@Autowired
	private ServicerRepository servicerRepository;
	@Autowired
	LoadDataTemplate loadDataTemplate;
//	Show list by id category
	@RequestMapping(value = "/listByCategory/{id_category}", method = RequestMethod.GET)
	public String listByCategory(@PathVariable("id_category") int id_category, ModelMap modelMap) {
		Iterable<Servicer> services = servicerRepository.findAllByCategoryId(id_category);
		modelMap.addAttribute(services);
		loadDataTemplate.setDataTemplate(modelMap);
		return "default.service.byCategory";
	}
//Show detail by id
	@RequestMapping(value = "/byId/{id}",method = RequestMethod.GET)
	public String findById(@PathVariable("id") int id,ModelMap modelMap) {
		Servicer service=servicerRepository.findById(id).get();
		modelMap.addAttribute("service",service);
		loadDataTemplate.setDataTemplate(modelMap);
		return "default.service.byId";
	}
	
	@RequestMapping(value = {"/listAll",""},method = RequestMethod.GET)
	public String findAll(ModelMap modelMap) {
		Iterable<Servicer> services=servicerRepository.findAll();
		modelMap.addAttribute(services);
		loadDataTemplate.setDataTemplate(modelMap);
		return "default.service.all";
	}
}
