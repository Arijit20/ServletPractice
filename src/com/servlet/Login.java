package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String nameRegex = "^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$";
		
		String name = request.getParameter("user");
		if (name.matches(nameRegex)) {
			request.setAttribute("user", name);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Entered Name is in wrong format. Eg. John Smith</font>");
			rd.include(request, response);
			out.close();
		}
	}
}