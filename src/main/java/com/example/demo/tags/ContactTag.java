package com.example.demo.tags;

import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class ContactTag extends RequestContextAwareTag{
	
	@Override
	public void doFinally() {
		// TODO Auto-generated method stub
		JspWriter jspWriter=pageContext.getOut();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.doFinally();
	}
	@Override
	protected int doStartTagInternal() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
