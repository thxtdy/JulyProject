package com.uni.system.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("professor my : " + action);
		switch (action) {
		case "/pwd":
			System.out.println("여기들어오나");
			changePassword(request, response);
		default:
			break;
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("username");
		String afterPW = request.getParameter("afterPW");
		String beforePW = request.getParameter("beforePW");
		System.out.println( "id : " + id +" afterPW : "+ afterPW + "beforePW" + beforePW);

	}

}
