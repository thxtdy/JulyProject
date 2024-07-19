package com.uni.system.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
@WebServlet("/info/*")
=======
import java.io.IOException;


>>>>>>> 35fbf81f86f135f88469202886ee73b347fa6a25
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD

		
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
=======
>>>>>>> 35fbf81f86f135f88469202886ee73b347fa6a25
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
	
	
	


