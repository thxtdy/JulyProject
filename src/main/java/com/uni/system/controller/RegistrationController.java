package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.model.College;
import com.uni.system.service.StaffRepositoryImpl;

@WebServlet("/admin/*")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StaffRepository staffRepository;

	@Override
	public void init() throws ServletException {
		staffRepository = new StaffRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("get PATHINO" + action);
		switch (action) {
		case "/college":
			viewCollege(request, response);
			processCRUD(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/registration.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}

	private void processCRUD(HttpServletRequest request, HttpServletResponse response) {
		String crud = request.getParameter("crud");
		String crudType = "";
		if ("insert".equals(crud)) {
			crudType = "<form action=\"" + request.getContextPath() + "/admin/college\" method=\"POST\">"
					+ "<input type=\"text\" name=\"college_name\" placeholder=\"단과대학을 입력해주세요\">"
					+ "<button type=\"submit\">입력</button>" + "</form>";
			request.setAttribute("crudType", crudType);
		} else {
			request.setAttribute("crudType", ""); 
		}
		if ("delete".equals(crud)) {
			
		}
		
	}

	private void viewCollege(HttpServletRequest request, HttpServletResponse response) {
		List<College> collegeList = staffRepository.viewAllCollege();
		request.setAttribute("collegeList", collegeList);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/college":
			addCollege(request,response);
			response.sendRedirect(request.getContextPath()+ "/admin/college?crud=insert");
			break;

		default:
			break;
		}
	}

	private void addCollege(HttpServletRequest request, HttpServletResponse response) {
		String collegeName = request.getParameter("college_name");
		staffRepository.addCollege(collegeName);
	}

}
