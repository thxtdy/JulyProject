package com.uni.system.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
    }
    
    @Override
    public void init() throws ServletException {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		sre user.role
		System.out.println("action : " + action);
			
			switch (sre) {
			case "학생":
				request.getRequestDispatcher("WEB-INF/views/signIn.jsp").forward(request, response);
				break;
			case "교수":
				request.getRequestDispatcher("WEB-INF/views/signIn.jsp").forward(request, response);
				break;
			case "직원":
				request.getRequestDispatcher("WEB-INF/views/signIn.jsp").forward(request, response);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
