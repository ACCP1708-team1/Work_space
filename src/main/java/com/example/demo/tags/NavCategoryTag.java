package com.example.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NavCategoryTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub
		super.setParent(parent);
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return super.getParent();
	}

	@Override
	public void setJspContext(JspContext pc) {
		// TODO Auto-generated method stub
		super.setJspContext(pc);
	}

	@Override
	protected JspContext getJspContext() {
		// TODO Auto-generated method stub
		return super.getJspContext();
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
	}

	@Override
	protected JspFragment getJspBody() {
		// TODO Auto-generated method stub
		return super.getJspBody();
	}

}
