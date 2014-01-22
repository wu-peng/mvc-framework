package com.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.action.Action;
import com.mvc.action.ActionForm;
import com.mvc.entity.MvcBean;

public class MvcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public MvcServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String path = request.getServletPath();
		Map<String, MvcBean> map = (Map<String, MvcBean>) request.getServletContext().getAttribute("mvc");
		MvcBean mvcBean = map.get(path);
		ActionForm form = getBean(mvcBean.getEntityClass(),request);
		Action action = null;
		try {
			Class<?> class1 = Class.forName(mvcBean.getActionClass());
			action = (Action) class1.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String str = action.execute(form);
		String url = mvcBean.getForward().get(str);
		if (url==null) {
			url="";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private ActionForm getBean(String className,HttpServletRequest request) {
		ActionForm o = null;
		try {
			Class<?> clazz = Class.forName(className);
			o = (ActionForm) clazz.newInstance();
			Field[] fields = clazz.getFields();
			for (Field field : fields) {
				field.setAccessible(true);
				field.set(o, request.getParameter(field.getName()));
				field.setAccessible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o ;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
