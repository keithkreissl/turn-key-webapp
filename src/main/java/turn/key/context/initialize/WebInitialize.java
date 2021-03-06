package turn.key.context.initialize;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import turn.key.context.service.ServiceContext;
import turn.key.context.web.WebContext;

@EnableWebMvc
@Order(1)
public class WebInitialize extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("contextConfigLocation", "");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//The root configuration classes will live here
		return new Class<?>[]{ServiceContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//The controller configuration classes will be here
		return new Class<?>[]{WebContext.class};
	}

	@Override
	protected String[] getServletMappings() {
		//Servlet mapping for what the application listens on
		return new String[]{"/"};
	}
	
	

}
