package com.uni.system.controller;

import java.io.IOException;

import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;

	public UserController() {
		userRepository = new UserRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("DOGET PathInfo : " + action);
		switch (action) {
		case "/signup":
			request.getRequestDispatcher("/WEB-INF/six/user/signup.jsp").forward(request, response);
		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;

		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println("action : " + action);

		switch (action) {
		case "/signIn":
			handleSignIn(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleSignIn(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDTO principal = userRepository.getUserbyUsername(Integer.parseInt(username), password);

		if (principal != null && principal.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);

			response.sendRedirect(request.getContextPath() + "/six/subject.jsp");
			response.sendRedirect(request.getContextPath() + "/subject.jsp");

		} 

		}


}
