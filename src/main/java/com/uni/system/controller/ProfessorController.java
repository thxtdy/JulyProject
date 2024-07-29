package com.uni.system.controller;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.StuSub;
import com.uni.system.repository.model.Subject;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.ProfessorRepositoryimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProfessorRepository professorRepository;
	
		
	@Override
	public void init() throws ServletException {
		professorRepository = new ProfessorRepositoryimpl();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("professor my : " + action);

		switch (action) {
		case "/myClass":
			handleSubject(request, response);
			break;
			// 수강 신청한 학생 목록 보는 것입니다.
		case "/myClassStudent":
			handleMyStudent(request, response);
			break;
			// 학생 평가하겠습니다.. 차은우 F학점
		case "/evaluationStudent":
			System.out.println("evaluationStudent 호출");
			handleEvaluation(request, response);
			break;
		case "/myClassEvaluation":

			break;

		default:
			break;
		}
	}


	/**
	 * 학생 성적에 대한 상세 정보를 확인합니다
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleEvaluation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		List<StuSub> studentList = professorRepository.viewMyStudentByUserId(studentId);
		request.setAttribute("studentId", studentList);
		request.getRequestDispatcher("/WEB-INF/views/professor/evaluationStudent.jsp").forward(request, response);
		
	}
	/**
	 * 교수가 맡고 있는 수업을 신청한 학생들을 보여줍니다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleMyStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("handleMyStudent 호출");
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		List<StuSub> studentList = professorRepository.viewMyStudent(subjectId);
		request.setAttribute("studentList", studentList);
		
		request.getRequestDispatcher("/WEB-INF/views/professor/myStudent.jsp").forward(request, response);
		
	}
	/**
	 * 교수가 담당하고 있는 수업 목록을 보여줍니다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
		
		String action = request.getPathInfo();
		
		switch (action) {
		case "/evaluationStudent":
			evaluationStudent(request, response);
			break;

		default:
			break;
		}
		
	}

	private void evaluationStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int absent = Integer.parseInt(request.getParameter("absent"));
		int lateness = Integer.parseInt(request.getParameter("lateness"));
		int homework = Integer.parseInt(request.getParameter("homework"));
		int midExam = Integer.parseInt(request.getParameter("midExam"));
		int finalExam = Integer.parseInt(request.getParameter("finalExam"));
		int converted = Integer.parseInt(request.getParameter("converted"));
		String grade = request.getParameter("grade");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		System.out.println("evaluation에서 찍는 학생 ID : " + studentId);
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		System.out.println("evaluation에서 찍는 강의 ID : " + subjectId);
		professorRepository.evaluationStudent(absent, lateness, homework, midExam, finalExam, converted, studentId, subjectId);
		System.out.println("결석" + absent);
		System.out.println("지각" + lateness);
		System.out.println("과제" + homework);
		System.out.println("중간" + midExam);
		System.out.println("기말" + finalExam);
		System.out.println("합산" + converted);
		System.out.println("학점" + grade);
		
		request.getRequestDispatcher("/WEB-INF/views/user/professorClass.jsp").forward(request, response);
		
	}

}
