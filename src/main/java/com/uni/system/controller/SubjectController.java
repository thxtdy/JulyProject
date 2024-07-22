package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SubjectRepository;
import com.uni.system.repository.model.SubjectLectureList;
import com.uni.system.service.SubjectRepositoryImpl;

@WebServlet("/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectRepository subjectRepository;

	@Override
	public void init() throws ServletException {
		subjectRepository = new SubjectRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleList(request, response);
//		String action = request.getPathInfo();
//		System.out.println("GET action: " + action);
//		switch (action) {
//		case "/subject":
//			handleSubject(request, response);
//			break;
//		case "/list":
//			break;
//
//		default:
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			break;
//		}
	}

	private void handleSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<SubjectLectureList> subjectList = subjectRepository.selectAllTable();
		System.out.println("subjectList : " + subjectList.toString());
		request.setAttribute("subjectList", subjectList);
		response.sendRedirect(request.getContextPath() + "/subject.jsp");
	}

	private void handleList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String deptName = request.getParameter("dept_id");
		int deptId = Integer.parseInt(deptName);
		String lectureName = request.getParameter("lecture_name");
		List<SubjectLectureList> subjectList = subjectRepository.selectByYearAndSemester(Integer.parseInt(year),
				Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);

		if (year != null && semester != null && deptId == -1 && lectureName.isEmpty()) {
			subjectList = subjectRepository.selectByYearAndSemester(Integer.parseInt(year), Integer.parseInt(semester));
			System.out.println("개설학과와 강의명을 선택 안했을경우 : " + subjectList);

		} else if (year != null && semester != null && deptId != -1 && lectureName.isEmpty()) {
			subjectList = subjectRepository.selectBySemesterAndDeptAndName(Integer.parseInt(year),
					Integer.parseInt(semester), deptId);
			System.out.println("강의명을 선택 안했을경우 :  " + subjectList);

		} else if (year != null && semester != null && deptId != -1 && !lectureName.isEmpty()) {
			subjectList = subjectRepository.selectBySemesterAndDeptAndNameAndTpye(Integer.parseInt(year),
					Integer.parseInt(semester), deptId, lectureName);
			System.out.println("다 선택했을 경우 : " + subjectList);

		} else if (year != null && semester != null && deptId == -1 && !lectureName.isEmpty()) {
			subjectList = subjectRepository.selectByYearAndSemesterAndType(Integer.parseInt(year),
					Integer.parseInt(semester), lectureName);
			System.out.println("개설학과만 선택 안했을 경우 : " + subjectList);
		}
		request.setAttribute("subjectList", subjectList);
		request.getRequestDispatcher(request.getContextPath() + "/subject.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
