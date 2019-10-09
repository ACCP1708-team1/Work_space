package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.example.demo.entities.Category;
import com.example.demo.entities.ContactUs;
import com.example.demo.entities.Project;
import com.example.demo.entities.ProjectStatus;
import com.example.demo.entities.Servicer;

@Component
public class LoadDataTemplate {
	@Autowired
	CategoryModel categoryModel;
	@Autowired
	ProjectStatusModel projectStatusModel;
	@Autowired
	ProjectModel projectModel;
	@Autowired
	ServiceModel serviceModel;
	@Autowired
	ContactUsModel contactUsModel;

	public List<Project> listAllProject() {
		return projectModel.findAll();
	}

	public List<Category> listAllCategory() {
		// CategoryModel categoryModel=new CategoryModel();
		return categoryModel.findAll();
	}

	public ContactUs newContact() {
		return contactUsModel.getNewContact();
	}

	public List<ProjectStatus> listAllProjectStatus() {
		// TODO Auto-generated method stub
		// ProjectStatusModel projectStatusModel=new ProjectStatusModel();
		return projectStatusModel.findAll();
	}

	public List<Servicer> listAllService() {
		return serviceModel.findAll();
	}

	public void setDataTemplate(ModelMap modelMap) {
		modelMap.put("categoriesTemplate",listAllCategory());
		// Get new Contact
		modelMap.addAttribute("contactUsTemplate", newContact());

		// Get list projectStatus
		modelMap.addAttribute("projectStatusTemplate", listAllProjectStatus());

	}
}
