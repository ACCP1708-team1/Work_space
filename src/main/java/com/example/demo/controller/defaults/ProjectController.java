package com.example.demo.controller.defaults;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Project;
import com.example.demo.repository.ProjectRepository;

@Controller
@RequestMapping(value = "project")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;

//	Show list Project by status project
	@RequestMapping(value = "/listByStatus/{idProjectStatus}", method = RequestMethod.GET)
	public String listProject(@PathVariable("idProjectStatus") int id, ModelMap modelMap) {
		List<Project> projects = projectRepository.findByIdStatus(id);
		modelMap.addAttribute("projects", projects);
		return "default.projects-status";
	}

// Show project by id project
	@RequestMapping(value = "/detailProject/{id}", method = RequestMethod.GET)
	public String detailProject(@PathVariable("id") int id, ModelMap modelMap) {
		Project project = projectRepository.findById(id).get();
		modelMap.addAttribute("project", project);
		return "default.project-detail";
	}
//Show All project
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll( ModelMap modelMap) {
		Iterable<Project> projects=projectRepository.findAll();
		modelMap.addAttribute("projects", projects);
		return "default.projects-findAll";
	}
}
