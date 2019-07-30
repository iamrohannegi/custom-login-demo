package com.rohan.login.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Registers dispatcher servlet and allow Java-based Spring configuration
public class LoginAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { LoginAppConfig.class};
	}
	
	//Specify servlet mappings for dispatcher servlet
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
