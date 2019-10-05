package com.example.demo.controller.defaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.LoadDataTemplate;

/// Trang Index
@Controller
@RequestMapping(value = { "" })
public class HomeController {
	@Autowired
	LoadDataTemplate loadDataTemplate;
	@RequestMapping(value = { "", "home" }, method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		loadDataTemplate.setDataTemplate(modelMap);
		modelMap.addAttribute("services",loadDataTemplate.listAllService());
		modelMap.addAttribute("categories",loadDataTemplate.listAllCategory());
		modelMap.addAttribute("projectStatus",loadDataTemplate.listAllProjectStatus());
		return "default.home";
	}
}
