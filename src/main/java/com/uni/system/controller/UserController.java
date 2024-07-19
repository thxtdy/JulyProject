package com.uni.system.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/info/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getContextPath();
		
		switch (action) {
		case "/student":
			request.getRequestDispatcher("WEB-INF/views/user/studentInfo.jsp").forward(request, response);
			break;

		case "/professor":
			request.getRequestDispatcher("WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		
		case "/employee":
			request.getRequestDispatcher("WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		switch (action) {
		case "/signIn":
			signIn(request,response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;
			
		}
		
		
		
		
	}
	
}
	
	
	


