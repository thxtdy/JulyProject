package com.uni.system.controller;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.NoticeRepository;
import com.uni.system.repository.model.NoticeList;
import com.uni.system.service.NoticeRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeRepository noticeRepository;

	public NoticeController() {
		noticeRepository = new NoticeRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println("GET action: " + action);
		switch (action) {
		case "/notice":
			handleNotice(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleNotice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NoticeList> noticelist = noticeRepository.selectAllTable();
		
		request.setAttribute("noticelist", noticelist);
		request.getRequestDispatcher("/WEB-INF/views/notice/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
