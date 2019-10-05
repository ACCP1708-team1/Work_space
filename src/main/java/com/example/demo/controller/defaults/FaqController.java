package com.example.demo.controller.defaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Faq;
import com.example.demo.models.FaqModel;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@Autowired
	FaqModel faqModel;
	
	@RequestMapping(value = "/faqall", method = RequestMethod.GET)
	public String faq(ModelMap modelMap) {
		List<Faq> faqs = faqModel.findAll();
		modelMap.addAttribute("faqs", faqs);
		return "default.faqall";
	}
}
