package com.uni.system.controller;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.SugangRepository;
import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;
import com.uni.system.service.SugangRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SugangRepository sugangRepository;
	
	@Override
	public void init() throws ServletException {
		sugangRepository = new SugangRepositoryImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/subjectList":
			getChecks(request,response);
			
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void getChecks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SugangDTO> type= sugangRepository.getSugangType();
		List<SugangDTO> sugangDeptName = sugangRepository.getSugangDeptName();
		List<SugangDTO> sugangLectureName = sugangRepository.getSugangLectureName();
		List<SugangColumn> sugangColumnList = sugangRepository.viewSugangColumn();
		
		request.setAttribute("sugangColumnList", sugangColumnList);
		request.setAttribute("sugangType", type);
		request.setAttribute("sugangDeptName", sugangDeptName);
		request.setAttribute("sugangLectureName", sugangLectureName);
		request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
