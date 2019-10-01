package com.example.demo.controller.defaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Servicer;
import com.example.demo.repository.ServicerRepository;

@Controller
@RequestMapping(value = "service")
public class ServiceController {
	@Autowired
	private ServicerRepository servicerRepository;

//	Show list by id category
	@RequestMapping(value = "/listByCategory/{id_category}", method = RequestMethod.GET)
	public String listByCategory(@PathVariable("id_category") int id_category, ModelMap modelMap) {
		Iterable<Servicer> servicers = servicerRepository.findAllByCategoryId(id_category);
		modelMap.addAttribute(servicers);
		return "default.services-category";
	}
//Show detail by id
	@RequestMapping(value = "/detailById/{id}",method = RequestMethod.GET)
	public String detailById(@PathVariable("id") int id,ModelMap modelMap) {
		Servicer servicer=servicerRepository.findById(id).get();
		modelMap.addAttribute("servicer",servicer);
		return "default.detail-service";
	}
	
	@RequestMapping(value = {"/listAll",""},method = RequestMethod.GET)
	public String findAll(ModelMap modelMap) {
		Iterable<Servicer> servicers=servicerRepository.findAll();
		modelMap.addAttribute(servicers);
		return "default.services-all";
	}
}
