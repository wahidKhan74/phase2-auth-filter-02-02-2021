package com.ecom.filter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

@WebFilter("/hello")
public class AuthFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		System.out.println("-- Destory Filter --");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// fetch all request parameters
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// get printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(email.equals("admin@gmail.com")) {
			if(password.equals("password@123")) {
				// next action / or next filter in chain
				out.print("filter is invoked before");
				chain.doFilter(request, response);
				out.print("filter is invoked after");
			}
		} else {
			out.print("<h2>User Not Found with given email "+email+"</h2>");
			out.print("<p>looking for default email as admin@gmail.com </p>");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("-- Initialize Filter --");
	}

}
