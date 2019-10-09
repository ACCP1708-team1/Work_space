package com.example.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.example.demo.repository.CategoryRepository;

@Service
public class TemplateTag extends RequestContextAwareTag{

	/**
	 * 
	 */
	//@Autowired
	 CategoryRepository categoryRepository;
	//@Autowired
//	ProjectRepository projectRepository;
	//@Autowired
//	ContactUsRepository contactUsRepository;
	//@Autowired
//	ProjectStatusRepository projectStatusRepository;
//	@Autowired
//	ServicerRepository servicerRepository;
//	@Override
//	public void setJspContext(JspContext pc) {
//		// TODO Auto-generated method stub
//		super.setJspContext(pc);
		
//	}
//	@Override
//	public void doTag() throws JspException, IOException {
//		// TODO Auto-generated method stub
//		super.doTag();
//		//PageContext pageContext = (PageContext) getJspContext();
//		JspWriter out = pageContext.getOut();
//		//setJspContext(getJspContext());
//		out.println("<h3>Hello word</h3>");
//	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void doFinally() {
		JspWriter jspWriter=pageContext.getOut();
		pageContext.setAttribute("categories",categoryRepository.findAll());
//		pageContext.setAttribute("projects", projectRepository.findAll());
//		pageContext.setAttribute("contactUs", contactUsRepository.newContact());
//		pageContext.setAttribute("projectStatus",projectStatusRepository.findAll());
//		pageContext.setAttribute("services",servicerRepository.findAll());
		try {
			jspWriter.print("<h3>welcome home</h3>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		super.doFinally();
	}

	@Override
	protected int doStartTagInternal() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
//@Autowired
//	public TemplateTag(CategoryRepository categoryRepository, ProjectRepository projectRepository,
//			ContactUsRepository contactUsRepository, ProjectStatusRepository projectStatusRepository,
//			ServicerRepository servicerRepository) {
//		super();
//		this.categoryRepository = categoryRepository;
//		this.projectRepository = projectRepository;
//		this.contactUsRepository = contactUsRepository;
//		this.projectStatusRepository = projectStatusRepository;
//		this.servicerRepository = servicerRepository;
//	}
@Autowired
	public TemplateTag(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
}
