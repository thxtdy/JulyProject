package com.uni.system.controller;

import java.io.IOException;

import com.uni.system.repository.UserRepositoryImpl;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.User;
import com.uni.system.repository.model.UserDTO;

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

<<<<<<< HEAD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/student":
			request.getRequestDispatcher("/WEB-INF/views/user/studentInfo.jsp").forward(request, response);
=======
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("DOGET PathInfo : " + action);
		switch (action) {
		case "/signup":
			request.getRequestDispatcher("/WEB-INF/six/user/signup.jsp").forward(request, response);
>>>>>>> 1c98975819d24d9465e16590ce57fea170488345
			break;
		case "/signIn":
			request.getRequestDispatcher("/WEB-INF/six/user/signIn.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

<<<<<<< HEAD
		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		
		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println("action : " + action);

		switch (action) {
		case "/signIn":
			handleSignIn(request, response);
>>>>>>> 1c98975819d24d9465e16590ce57fea170488345
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDTO principal = userRepository.getUserbyRole(password);
		
		if(principal != null && principal.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);
			
			System.out.println("로그인 완료 ");
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/six/subject.jsp");
			
		} else {
			request.setAttribute("errorMessage", "잘못된 요청입니다");
			request.getRequestDispatcher("/subject.jsp").forward(request, response);
			
		}
		
		System.out.println("username : " + username + "password : " + password);
		UserDTO dto = userRepository.getUserbyUsername(Integer.parseInt(username), password);		
		System.out.println(dto.getUserRole());
		
		if (username == null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;

			
		} else if (dto.getUserRole().equals("student")) {
			response.sendRedirect("signIn?message=success");
			
		}

	}

}
