package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.Subject;
import com.uni.system.repository.model.SubjectLectureList;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.ProfessorRepositoryimpl;


@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProfessorRepository professorRepository;
		
	@Override
	public void init() throws ServletException {
		professorRepository = new ProfessorRepositoryimpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("professor my : " + action);
		
		switch (action) {
		case "/myClass":
			handleSubject(request, response);
			break;
			
		case "/myClassEvaluation":
			
			break;
			
		default:
			break;
		}
	}

	private void handleSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		System.out.println("자 교수의 아이디를 뽑아볼까? " + dto.getId());
		// 여기까지 들어왔음 1회차
		List<Subject> myList = professorRepository.viewSubjectById(dto.getId());
		// 들어오긴 했는데 데이터가 없음 [] 로 나옴
		System.out.println("교수의 담당 수업 목록 : " + myList.toString());
		request.setAttribute("myList", myList);
		request.getRequestDispatcher("/WEB-INF/views/user/professorClass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
