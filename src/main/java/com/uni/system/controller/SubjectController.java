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
		String action = request.getPathInfo();
		System.out.println("GET action: " + action);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String deptName = request.getParameter("dept_id");
		int deptId = Integer.parseInt(deptName);
		String lectureName = request.getParameter("lecture_name");
		System.out.println("year : " + year);
		System.out.println("semester : " + semester);
		System.out.println("deptname : " + deptName);
		System.out.println("lectureName : " + lectureName);
		
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		
		if(year != null && semester != null && deptId== -1 && lectureName.isEmpty()) {
			System.out.println("deptId : " + deptId);
			subjectList = subjectRepository.selectByYearAndSemester(Integer.parseInt(year) ,Integer.parseInt(semester));
			System.out.println(subjectList);
		}
	}

}
