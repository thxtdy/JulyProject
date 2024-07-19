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
		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
<<<<<<< HEAD

		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
=======
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544
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
<<<<<<< HEAD
		UserDTO principal = userRepository.getUserbyRole(password);
=======
		UserDTO principal = userRepository.getUserbyUsername(Integer.parseInt(username), password);
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544

		if (principal != null && principal.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);

			System.out.println("로그인 완료 ");
			System.out.println(request.getContextPath());
<<<<<<< HEAD
			response.sendRedirect(request.getContextPath() + "/six/subject.jsp");
=======
			response.sendRedirect(request.getContextPath() + "/subject.jsp");
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544

		} else {
			request.setAttribute("errorMessage", "잘못된 요청입니다");
			request.getRequestDispatcher("/subject.jsp").forward(request, response);
<<<<<<< HEAD

		}

		System.out.println("username : " + username + "password : " + password);
		UserDTO dto = userRepository.getUserbyUsername(Integer.parseInt(username), password);
		System.out.println(dto.getUserRole());

		if (username == null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;

		} else if (dto.getUserRole().equals("student")) {
			response.sendRedirect("signIn?message=success");
=======

		}

		int userId = Integer.parseInt(request.getParameter("username")); // 23000001
		System.out.println(userId);
		String password = request.getParameter("password"); // 123123
		UserDTO principal = userRepository.getUserbyRole(userId);

		if (userId == principal.getId() && password.equals(principal.getPassword())) {

			if (username == null || password.trim().isEmpty()) {
				response.sendRedirect("signIn?message=invalid");
				return;

			} else {
				System.out.println("잘못된 요청입니다1111111");

				request.setAttribute("principal", principal);
				response.sendRedirect(password);
			}
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544

		}

	}
}
