package com.ecom.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/hello")
public class VisitCountFilter  implements Filter{
	// TODO : Create a visit count filter that counts total number of visits to application.
	static int count = 0;
	
	@Override
	public void destroy() {
		System.out.println("-- Destory VisitCountFilter Filter --");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		++count;  // increase visit count
		out.print("<h1> Total Visits :"+count +"</h1>");
		chain.doFilter(request, response);
		out.close();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("-- Initialize VisitCountFilter Filter --");
	}
	
}
