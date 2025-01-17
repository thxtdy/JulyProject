package com.uni.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SugangRepository;
import com.uni.system.repository.model.PreStuSub;
import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;
import com.uni.system.repository.model.SugangPreAppList;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		// 강의 시간표 조회
		case "/subjectList":
			getChecks(request, response);
			viewLists(request, response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
			break;
		// 강의 시간표 필터
		case "/filter":
			viewSlectedLecture(request, response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
			break;
		// 예비 수강 신청 필터
		case "/preFilter":
			viewSlectedPreLecture(request, response);
			break;
		// 예비 신청 페이지
		case "/pre":
			correctList(request, response);
			handleCansleSelectBtn(request, response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/pre.jsp").forward(request, response);
			break;
		// 선택된 예비 신청 목록
		case "/preAppList":
			request.getRequestDispatcher("/WEB-INF/views/sugang/preAppList.jsp").forward(request, response);
			break;
//			// 찐 수강 신청 
		case "/appList":
			getPreAppList(request, response);
			getAppList(request, response);
			request.getRequestDispatcher("/WEB-INF/views/sugang/appList.jsp").forward(request, response);
			break;
		case "/appInfo":
			getAppList(request, response);
			
			request.getRequestDispatcher("/WEB-INF/views/sugang/appInfo.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	// 사전 수강신청 페이지에서 중복/ 다른과 신청하는거 방지 
	private void handleCansleSelectBtn(HttpServletRequest request, HttpServletResponse response) {
		String principalId = request.getParameter("principal");
		int principal = Integer.parseInt(principalId);
		int deptId = sugangRepository.getDeptId(principal);
		
		System.out.println("deptId : " + deptId);
		
		List<PreStuSub> ps = sugangRepository.duplicateCheck();
		
		request.setAttribute("deptId", deptId);
		request.setAttribute("duplicateCheck", ps);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/selectedList":
			viewSelectedLecture(request, response);
			break;
		case "/deleteApp":
			deletePreApp(request, response);
			break;
		case "/addSugang":
			handleSub(request, response);
			response.sendRedirect(request.getContextPath() + "/sugang/appList?principal=" + request.getParameter("principal"));
			break;
			// 수강신청 페이지에서 취소 눌렀을때 수강 취소하기 
		case "/cansleSugang":
			deleteRealApp(request, response);
			response.sendRedirect(request.getContextPath() + "/sugang/appList?principal=" + request.getParameter("principal"));
			break;
		default:
			break;
		}
	}

	// 찐 수강 신청 페이지에서 예비 신청말고 찐으로 수강신청 된 강의 취소하기 
	private void deleteRealApp(HttpServletRequest request, HttpServletResponse response) {
		String haksuNumStr = request.getParameter("haksuNum");
		String principalStr = request.getParameter("principal");
		System.out.println("haksuNumStr : " + haksuNumStr);
		System.out.println("principalStr : " + principalStr);
		int haksuNum = Integer.parseInt(haksuNumStr);
		int principalId = Integer.parseInt(principalStr);
		sugangRepository.deleteAdd(haksuNum);
		sugangRepository.addSelectedPreAdd(principalId,haksuNum);
	}

	private void getAppList(HttpServletRequest request, HttpServletResponse response) {
		// 접속한 아이디
		String principalStr = request.getParameter("principal");
		int principalId = Integer.parseInt(principalStr);
		
		// 찐수강 리스트 보이게하기
		List<SugangPreAppList> selectedRealLect = sugangRepository.viewSelectedAdd(principalId);
		request.setAttribute("selectedRealLect", selectedRealLect);
		
		// 총 학점 계산
		int sumOfGrades = sugangRepository.sumGrade(principalId);
		request.setAttribute("sumOfGrades", sumOfGrades);
	}
	
	/**
	 *  수강신청 페이지에서 예비 수강 신청한 데이터 신청버튼 누르고 찐 수강 리스트에 올리기
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleSub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String haksuNumStr = request.getParameter("selectedList");
		String principalStr = request.getParameter("principal");
		int haksuNum = Integer.parseInt(haksuNumStr);
		int principalId = Integer.parseInt(principalStr);
		
		sugangRepository.addSugangList(principalId, haksuNum);
		List<SugangPreAppList> selectedLect = sugangRepository.viewSelectedPreAdd(principalId);
		request.setAttribute("selectedLect", selectedLect);
		sugangRepository.deletePreAdd(haksuNum);
		
	}

	// 찐 수강 신청 페이지에 예비수강 신청한 페이지 가져오기
	private void getPreAppList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String principalStr = request.getParameter("principal");
		int principalId = Integer.parseInt(principalStr);

		List<SugangPreAppList> selectedLect = sugangRepository.viewSelectedPreAdd(principalId);
		request.setAttribute("selectedLect", selectedLect);
	}

	// 예비 수강 신청 목록 삭제!
	private void deletePreApp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String haksuNumStr = request.getParameter("selectedList");
		String principalStr = request.getParameter("principal");
		String numOfStudentStr = request.getParameter("numOfStudent");
		
		int haksuNum = Integer.parseInt(haksuNumStr);
		int principalId = Integer.parseInt(principalStr);
		int numOfStudent = Integer.parseInt(numOfStudentStr);
		
		// 예비수강 페이지 삭제하기!!!
		sugangRepository.deletePreAdd(haksuNum);

		// 신청한 예비수강한 리스트들 뽑아오기!!!!!!!!!
		List<SugangPreAppList> selectedLect = sugangRepository.viewSelectedPreAdd(principalId);
		request.setAttribute("selectedLect", selectedLect);
		sugangRepository.minusPreNumOfStudent(haksuNum, numOfStudent - 1);
		// 페이징 처리!!!!!!!!!!!!!
		getChecks(request, response);

		// 검색필터 목록값!!
		viewLists(request, response);
		request.getRequestDispatcher("/WEB-INF/views/sugang/preAppList.jsp").forward(request, response);
	}

	// 예비수강 페이지에서 선택한 목록 나오게하기
	private void viewSelectedLecture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectedListStr = request.getParameter("selectedList");
		String principalIdStr = request.getParameter("principal");
		String numOfStudentStr = request.getParameter("numOfStudent");
		int selectedLec = Integer.parseInt(selectedListStr);
		int principalId = Integer.parseInt(principalIdStr);
		int numOfStudent = Integer.parseInt(numOfStudentStr);
		
		// 신청한 학생수 카운트하기 haksuNum , numOfStudent
		sugangRepository.plusPreNumOfStudent(numOfStudent + 1 , selectedLec);
		
		// 예비신청 리스트에 추가하기
		sugangRepository.addSelectedPreAdd(principalId, selectedLec);

		// 선택된 강의 학수번호
		List<SugangPreAppList> selectedLect = sugangRepository.viewSelectedPreAdd(principalId);
		request.setAttribute("selectedLect", selectedLect);
		
		// 예비 신청한 학점 합계
		int preGradeSum = sugangRepository.sumPreGrade(principalId);
		request.setAttribute("preGradeSum", preGradeSum);
		
		// 페이징 처리!!!!!!!!!!!!!
		getChecks(request, response);

		// 검색 필터 목록값!!
		viewLists(request, response);
		request.getRequestDispatcher("/WEB-INF/views/sugang/preAppList.jsp").forward(request, response);
	}

	private void viewSlectedPreLecture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 강의 목록 경우의수 계산 + viewLists() 호출 함으로써 검색필터 목록값 가져오기!
		viewSlectedLecture(request, response);

		request.getRequestDispatcher("/WEB-INF/views/sugang/pre.jsp").forward(request, response);
	}

	private void correctList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 페이징처리!!!!!
		getChecks(request, response);

		// 검색필터 목록값들!!
		viewLists(request, response);
		
		// 이미 신청한 과목들을 취소버튼으로 변경하기 위해 이미 예비수강신청을 했는지 확인하는 메소드 
		
	}

	// 강의 목록 필터!!
	private void viewSlectedLecture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SugangColumn> sugangColumnList = new ArrayList<SugangColumn>();
		int totalBoards = 0;

		String type = request.getParameter("type");
		String deptId = request.getParameter("deptId");
		String subName = request.getParameter("subName");

		viewLists(request, response);

		// 강의구분, 개설학과가 전체이고 강의명이 비어있을 경우
		if (type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.viewSugangValues();
			totalBoards = sugangRepository.getAllCount();

			// 강의구분만 선택 했을 시
		} else if (!type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			System.out.println("강의구분만 선택 했을 시");
			sugangColumnList = sugangRepository.selectType(type);
			totalBoards = sugangRepository.getSelectedTypeCount(type);

			// 개설학과만 선택 했을 시
		} else if (type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectDept(deptId);
			totalBoards = sugangRepository.getSelectedDeptId(deptId);

			// 강의명만 선택했을 시
		} else if (type.equals("ALL") && deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectLectureName(subName);
			totalBoards = sugangRepository.getSelectedLectureName(subName);

			// 강의구분 선택하고 개설학과 선택했을 경우
		} else if (!type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
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
		} else if (!type.equals("ALL") && !deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectAllFilter(type, deptId, subName);
			totalBoards = sugangRepository.getSelectedAll(type, deptId, subName);
		}

		request.setAttribute("sugangColumnList", sugangColumnList);
		request.setAttribute("totalBoards", totalBoards);

	}

	// 페이징 처리!!!!!!!!!
	private void getChecks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

	// 강의 시간표 검색 필터 옵션들 가져오기!!!!!!!!!!!
	private void viewLists(HttpServletRequest request, HttpServletResponse response) {
		List<SugangDTO> sugangType = sugangRepository.getSugangType();
		List<SugangDTO> sugangDeptName = sugangRepository.getSugangDeptName();
		List<SugangDTO> sugangLectureName = sugangRepository.getSugangLectureName();

		request.setAttribute("sugangType", sugangType);
		request.setAttribute("sugangDeptName", sugangDeptName);
		request.setAttribute("sugangLectureName", sugangLectureName);
	}

}
