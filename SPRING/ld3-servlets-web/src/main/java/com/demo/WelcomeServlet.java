package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TOO MUCH SERVLET SPECIFIC API
// LOTS OF BOILER PLATE CODE TOO
// ANNOTATION CONFIG....
//@WebServlet("/welcomeAnno")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head><title>Welcome to the Web</title></head>");
//		out.println("<body><h1>This demo is a warm-up for spring web.....from servlet....</h1></body>");
//		out.println("</html>");	
		 String htmlOutput = "<!DOCTYPE html>";
	        htmlOutput += "<html>";
	        htmlOutput += "<head><title>Welcome to the Web</title></head>";
	        htmlOutput += "<body><h1>This demo is a from spring boot and REST API ....</h1>" +
	                "<h1 style='color:red;font-weight:bold'>Ensures developer productivity!</h1> <br/> " +
	                " Enter text to search :  <input type = 'text' value=></input> <br/>" +
	                " <input type='Submit' value='Search'></input>";
	        htmlOutput += "</html>";
	        out.println(htmlOutput);
	}
}

