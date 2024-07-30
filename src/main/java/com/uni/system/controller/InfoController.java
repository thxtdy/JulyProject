package com.uni.system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Staff;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.ProfessorRepositoryimpl;
import com.uni.system.service.StaffRepositoryImpl;
import com.uni.system.service.StudentRepositoryImpl;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/info/*")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
	StudentRepository studentRepository;
	StaffRepository staffRepository;
	ProfessorRepository professorRepository;

	public InfoController() {
	}

	@Override
	public void init() throws ServletException {
		studentRepository = new StudentRepositoryImpl();
		staffRepository = new StaffRepositoryImpl();
		userRepository = new UserRepositoryImpl();
		professorRepository = new ProfessorRepositoryimpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {
		case "/student":
			System.out.println("Student");
			showStudentInfo(request, response);
			break;
		case "/studentPassword":
			request.getRequestDispatcher("/WEB-INF/views/user/studentChangePassword.jsp").forward(request, response);
			break;
		case "/staff":
			System.out.println("Staff");
			showStaffInfo(request, response);
			break;
		case "/staffPassword":
			System.out.println("staffPassowrd");
			request.getRequestDispatcher("/WEB-INF/views/user/staffChangePassword.jsp").forward(request, response);
			break;
		case "/professor":
			showProfessorInfo(request, response);
			break;
		case "/professorPassword":
			System.out.println("professorPassword");
			request.getRequestDispatcher("/WEB-INF/views/user/professorPassword.jsp").forward(request, response);
			break;
		case "/professorMy":
			request.getRequestDispatcher("/WEB-INF/views/user/professorMyInfo.jsp").forward(request, response);
			break;
		case "/changeStudentInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/studentMyInfoUpdate.jsp").forward(request, response);
			break;
		case "/changeStaffInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/staffMyInfoUpdate.jsp").forward(request, response);
			break;
		case "/changeProfessorInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/professorMyInfoUpdate.jsp").forward(request, response);
		default:
			break;
		}

	}

	private void showProfessorInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");

		if (dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Professor professor = professorRepository.viewMyInfo(dto.getId());
		session.setAttribute("professorInfo", professor);

		request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);

	}

	private void showStaffInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");

		if (dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Staff staffInfo = staffRepository.viewMyInfo(dto.getId());
		session.setAttribute("staffInfo", staffInfo);

		request.getRequestDispatcher("/WEB-INF/views/user/staffInfo.jsp").forward(request, response);
	}

	private void showStudentInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		System.out.println(dto.getId());
		if (dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Student studentInfo = studentRepository.viewMyInfo(dto.getId()); // student 반
		System.out.println("Student Infomation : " + studentInfo);
		session.setAttribute("studentInfo", studentInfo);

		request.getRequestDispatcher("/WEB-INF/views/user/studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {

		case "/studentPassword":
			changePassword(request, response);
			break;
		case "/staffPassword":
			changePassword(request, response);
			break;
		case "/professorPassword":
			changePassword(request, response);
			break;
		case "/updateStudent":
			changeInfomartion(request, response);
			break;
		case "/updateStaff":
			changeInfomartion(request, response);
			break;
		case "/updateProfessor":
			changeInfomartion(request, response);
		default:
			break;
		}
	}

	private void changeInfomartion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		
		String address = request.getParameter("address");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String email = request.getParameter("email");
		String checkPassword = request.getParameter("checkPassword");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userRole = request.getParameter("userRole");
		
		System.out.println("address : " + address);
		System.out.println("tel : " + tel);
		System.out.println("email : "  + email);
		System.out.println("checkPassword : " + checkPassword);
		System.out.println("Student ID : " + userId);
		
		if(userRole.equals("student") && checkPassword.equals(dto.getPassword())) {
			studentRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/student");
		} else if (userRole.equals("staff") && checkPassword.equals(dto.getPassword())) {
			staffRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/staff");
		} else if (userRole.equals("professor") && checkPassword.equals(dto.getPassword())) {
			professorRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/professor");
		} else if (!checkPassword.equals(dto.getPassword())){
				if(userRole.equals("student")) {
					response.sendRedirect(request.getContextPath() + "/info/student");
					alert(response);
					return;
				} else if (userRole.equals("staff")) {
					response.sendRedirect(request.getContextPath() + "/info/staff");
					alert(response);
					return;
				} else if (userRole.equals("professor")) {
					response.sendRedirect(request.getContextPath() + "/info/professor");
					alert(response);
					return;
				}
		  }
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("changedPassword Method 호출");
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		String currentPassword = request.getParameter("current_password");
		String changePassword = request.getParameter("change_password");
		System.out.println("유저 아이디" + dto.getId());
		System.out.println("현재 입력한 비밀번호 : " + currentPassword);
		System.out.println("바꾸려고 하는 비밀번호 : " + changePassword);
		System.out.println("DB에 있는 비번 : " + dto.getPassword());

		if (dto.getId() != 0 && currentPassword.equals(dto.getPassword())) {
			userRepository.changePassword(changePassword, dto.getId());
			response.sendRedirect(request.getContextPath() + "/user/home");

		} else if (dto.getUserRole().equals("student") && currentPassword != dto.getPassword()) {
			response.sendRedirect(request.getContextPath() + "/info/student?error");
		} else if (dto.getUserRole().equals("staff") && currentPassword != dto.getPassword()) {
			response.sendRedirect(request.getContextPath() + "/info/staff?error");
		} else if (dto.getUserRole().equals("professor") && currentPassword != dto.getPassword())
			response.sendRedirect(request.getContextPath() + "/info/professor?error");
	}
	
	public static void alert(HttpServletResponse response) {
	    try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("<script>alert('"+"비밀번호가 잘못되었습니다."+"');</script>");
			writer.flush();
			writer.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
	}

}
