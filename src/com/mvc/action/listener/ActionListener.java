package com.mvc.action.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mvc.util.XmlParse;

public class ActionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String xmlpath = context.getInitParameter("mvc-config");
		String tomcatpath =context.getRealPath("\\");
		System.out.println("======================================");
		System.out.println(tomcatpath+xmlpath);
		context.setAttribute("mvc", XmlParse.xmlParse(tomcatpath+xmlpath));
		System.out.println("提示：加载完成!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO ServletContex销毁

	}

}
