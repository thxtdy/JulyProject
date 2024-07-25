package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.uni.system.repository.interfaces.TuitionRepository;
import com.uni.system.repository.model.Grade;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.TuitionRepositoryImpl;
@WebServlet("/tuition/*")
public class TuitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TuitionRepository tuitionRepository;   
	
	
    public TuitionController() {

    }
    
    @Override
    public void init() throws ServletException {
    	tuitionRepository = new TuitionRepositoryImpl();
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("tuition controller");
		switch (action) {
		case "/list":
			request.getRequestDispatcher("/WEB-INF/views/tuition/tuitionList.jsp").forward(request, response);
			break;

		case "/payment":
			checkTuition(request, response);
			request.getRequestDispatcher("/WEB-INF/views/tuition/tuitionPaymentNotice.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
	}

	private void checkTuition(HttpServletRequest request, HttpServletResponse response) {
		

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
