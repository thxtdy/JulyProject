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
			break;
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

	private void handleSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
<<<<<<< HEAD

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDTO principal = userRepository.getUserbyUsername(Integer.parseInt(username), password);
		
		
		if(principal != null && principal.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);
			
			System.out.println("로그인 완료 ");
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/subject.jsp");
		
		} else {
			request.setAttribute("errorMessage", "잘못된 요청입니다");
			request.getRequestDispatcher("/subject.jsp").forward(request, response);
			
		}
=======
		
		int userId = Integer.parseInt(request.getParameter("username")); // 23000001
		System.out.println(userId);
		String password = request.getParameter("password"); // 123123
		UserDTO principal = userRepository.getUserbyRole(userId);
>>>>>>> ebdbf330f5c3c8e759771b450707cde9ae3e9a06
		
		if(userId == principal.getId() && password.equals(principal.getPassword())) {
		
<<<<<<< HEAD
		if (username == null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;

			
		} else {
			System.out.println("잘못된 요청입니다1111111");
			
=======
			request.setAttribute("principal", principal);
			response.sendRedirect(password);
>>>>>>> ebdbf330f5c3c8e759771b450707cde9ae3e9a06
		}

	}

}
