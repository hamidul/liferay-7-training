package com.proliferay.component.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
			"osgi.http.whiteboard.context.path=/",
			"osgi.http.whiteboard.servlet.pattern=/pro/servlet/*"
	},
	service = Servlet.class
)
public class ProServlet extends HttpServlet {


	private static final long serialVersionUID = 1342369217827208405L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.append("Hello from ProServlet"); 
	}

	

}