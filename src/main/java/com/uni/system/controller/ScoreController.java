package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.ScoreRepository;
import com.uni.system.repository.model.StuSub;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.ScoreRepositoryImpl;
@WebServlet("/score/*")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ScoreRepository scoreRepository;
    public ScoreController() {
    	scoreRepository = new ScoreRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/thisSemester":
			handleThisSemester(request, response);
			break;
		case "/bySemester":
			handleBySemester(request, response);
			break;
		case "/cumulative":
			handleCumulative(request, response);
			break;
		default:
			break;
		}
	}

	private void handleCumulative(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/six/score/cumulativeScore.jsp").forward(request, response);
	}

	private void handleBySemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/six/score/bySemesterScore.jsp").forward(request, response);
	}

	private void handleThisSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");		
		List<StuSub> studentScore = scoreRepository.viewThisSemester(dto.getId());
		request.setAttribute("score", studentScore);
		request.getRequestDispatcher("/WEB-INF/views/score/thisSemesterScore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
