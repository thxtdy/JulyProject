package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.ScheduleRepository;
import com.uni.system.repository.model.Schedule;
import com.uni.system.service.ScheduleRepositoryImpl;
@WebServlet("/schedule/*")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleRepository scheduleRepository;

	public ScheduleController() {
		scheduleRepository = new ScheduleRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println("GET action : " + action);
		switch (action) {
		case "/schedule":
			handleSchedule(request, response);
			break;

		default:
			break;
		}

	}

	private void handleSchedule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Schedule> schedulelist = scheduleRepository.selectAllscheduleTable();

		request.setAttribute("schedulelist", schedulelist);
		request.getRequestDispatcher("/WEB-INF/views/notice/schedule.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
