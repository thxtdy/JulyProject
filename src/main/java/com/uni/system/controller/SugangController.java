package com.uni.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SugangRepository;
import com.uni.system.repository.model.SubjectLectureList;
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
			// 강의 시간표 조회
		case "/subjectList":
			getChecks(request,response);
			viewLists(request, response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
			break;
			// 강의 시간표 필터
		case "/filter":
			viewSlectedLecture(request,response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
			break;
			// 예비 수강 신청 필터
		case "/preFilter":
			viewSlectedPreLecture(request,response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/pre.jsp").forward(request, response);
			break;
			// 예비 신청 페이지
		case "/pre":
			correctList(request,response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/pre.jsp").forward(request, response);
			break;
			// 선택된 예비 신청 목록
		case "/preAppList":
			request.getRequestDispatcher("/WEB-INF/views/sugang/preAppList.jsp").forward(request, response);
			break;
		case "/appList":
			request.getRequestDispatcher("/WEB-INF/views/sugang/appList.jsp").forward(request, response);
			break;
		case "/appInfo":
			request.getRequestDispatcher("/WEB-INF/views/sugang/appInfo.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/selectedList":
			viewSelectedLecture(request,response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/pre.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	
	// 예비수강 페이지에서 선택한 목록뽑기
	private void viewSelectedLecture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedList = request.getParameter("selectedList");
		// 선택된 강의 학수번호
		int selectedLecNum = Integer.parseInt(selectedList); 
		List<SugangColumn> selectedLect = sugangRepository.viewSelectedPreAdd(selectedLecNum);
		request.setAttribute("selectedLect", selectedLect);
		System.out.println(selectedLect);
		
		getChecks(request, response);
		viewLists(request, response);
	}
	
	private void viewSlectedPreLecture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewSlectedLecture(request, response);
	}
	
	private void correctList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getChecks(request, response);
		viewLists(request, response);
	}
	
	private void viewSlectedLecture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SugangColumn> sugangColumnList = new ArrayList<SugangColumn>();
		int totalBoards = 0;
		
		String type = request.getParameter("type");
		String deptId = request.getParameter("deptId");
		String subName = request.getParameter("subName");
		
		
		viewLists(request, response);
		
		// 강의구분, 개설학과가 전체이고 강의명이 비어있을 경우
		if(type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.viewSugangValues();
			totalBoards = sugangRepository.getAllCount();
			
		// 강의구분만 선택 했을 시
		} else if(!type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			System.out.println("강의구분만 선택 했을 시");
			sugangColumnList = sugangRepository.selectType(type);
			totalBoards = sugangRepository.getSelectedTypeCount(type);
			
		// 개설학과만 선택 했을 시
		} else if(type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectDept(deptId);
			totalBoards = sugangRepository.getSelectedDeptId(deptId);
			
		// 강의명만 선택했을 시	
		} else if(type.equals("ALL") && deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectLectureName(subName);
			totalBoards = sugangRepository.getSelectedLectureName(subName);
			
		// 강의구분 선택하고 개설학과 선택했을 경우
		} else if(!type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectTypeAndDept(type, deptId);
			totalBoards = sugangRepository.getSelectedTypeAndDept(type, deptId);
			
		// 개설학과와 강의명 선택했을 경우	
		} else if (type.equals("ALL") && !deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectDeptAndLectureName(deptId, subName);
			totalBoards = sugangRepository.getSelectedDeptAndLectureNameCount(deptId, subName);
			
		// 강의구분 선택하고 강의명 선택했을 경우
		} else if (!type.equals("ALL") && deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectTypeAndLectureName(type, subName);
			totalBoards = sugangRepository.getSelectedTypeAndLectureNameCount(type, subName);
			
		// 모든 필터를 선택 했을 경우
		} else if(!type.equals("ALL") && !deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectAllFilter(type, deptId, subName);
			totalBoards = sugangRepository.getSelectedAll(type, deptId, subName);
		}
		
		request.setAttribute("sugangColumnList", sugangColumnList);
		request.setAttribute("totalBoards", totalBoards);
		
	}
	private void getChecks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이징 처리
		int page = 1;
		int pageSize = 20;
		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page - 1) * pageSize;
		
		int totalBoards = sugangRepository.getAllCount();
		int totalPages = (int) Math.ceil((double) totalBoards / (double) pageSize);
		
		List<SugangColumn> sugangColumnList = sugangRepository.viewSugangColumn(pageSize, offset);
		
		request.setAttribute("totalBoards", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("sugangColumnList", sugangColumnList);
	}
	
	private void viewLists(HttpServletRequest request, HttpServletResponse response) {
		List<SugangDTO> sugangType= sugangRepository.getSugangType();
		List<SugangDTO> sugangDeptName = sugangRepository.getSugangDeptName();
		List<SugangDTO> sugangLectureName = sugangRepository.getSugangLectureName();
		
		
		request.setAttribute("sugangType", sugangType);
		request.setAttribute("sugangDeptName", sugangDeptName);
		request.setAttribute("sugangLectureName", sugangLectureName);
	}

}
