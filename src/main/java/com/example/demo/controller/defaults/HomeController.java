package com.example.demo.controller.defaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Category;
import com.example.demo.entities.ContactUs;
import com.example.demo.entities.Faq;
import com.example.demo.entities.Project;
import com.example.demo.entities.ProjectStatus;
import com.example.demo.entities.Servicer;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ContactUsRepository;
import com.example.demo.repository.FaqRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.ProjectStatusRepository;
import com.example.demo.repository.ServicerRepository;

/// Trang Index
@Controller
@RequestMapping(value = { "" })
public class HomeController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FaqRepository faqRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ServicerRepository servicerRepository;
	@Autowired
	private ContactUsRepository contacUsRepository;
	@Autowired
	private ProjectStatusRepository projectStatusRepository ;

//	@Autowired
//	private AboutUs
	@RequestMapping(value = {"","home"}, method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		// Add list category
		modelMap.put("categories",(List<Category>)categoryRepository.findAll());
		// add list FAQ
		Iterable<Faq> faqs = faqRepository.findAll();
		modelMap.addAttribute("faqs", faqs);
		// Add list project
		Iterable<Project> projects = projectRepository.findAll();
		modelMap.addAttribute("projects", projects);
		// Add list Service
		Iterable<Servicer> services = servicerRepository.findAll();
		modelMap.addAttribute("sercices", services);
		// Get new Contact
		ContactUs contactUs = contacUsRepository.newContact();
		modelMap.addAttribute("contactUs", contactUs);
		//Get list projectStatus
		Iterable<ProjectStatus> projectStatus=projectStatusRepository.findAll();
		modelMap.addAttribute("projectStatus",projectStatus);
		return "default.home";
	}
}
