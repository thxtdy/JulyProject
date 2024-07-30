package com.uni.system.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.model.BreakApp;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Staff;
import com.uni.system.repository.model.StuStat;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.Tuition;
import com.uni.system.utils.DBUtil;

public class StaffRepositoryImpl implements StaffRepository{
	
	// 교수 정보, 비밀번호 변경 쿼리
	final String STAFF_INFO = " SELECT * FROM staff_tb where id = ? ";
	final String CHANGE_PASSWORD = " UPDATE user_tb SET password = ? WHERE id = ? ";
	final String CHANGE_MY_INFO = " UPDATE staff_tb SET address = ?, tel = ?, email = ? WHERE id = ? ";

	// 학생, 교수, 직원 추가하는 쿼리
	final String ADD_STUDENT  = " insert into student_tb(name, birth_date, gender, address, tel, email, dept_id, grade, semester, entrance_date) values(?, ?, ?, ?, ?, ?, ?, 1, 1, ?);";
	final String ADD_PROFESSOR = "INSERT INTO professor_tb(name, birth_date, gender, address, tel, email, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?) ";
	final String ADD_STAFF = " INSERT INTO staff_tb (name, birth_date, gender, address, tel, email) VALUES (?, ?, ?, ?, ?, ?)";
	
	// 학생, 교수 명단 쿼리
	final String VIEW_ALL_STUDENT = " SELECT * FROM student_tb limit ? offset ? ";
	final String VIEW_ALL_STUDENT_COUNT = " SELECT count(*) AS row_count FROM student_tb ";
	final String VIEW_ALL_PROFESSOR = " SELECT * FROM professor_tb limit ? offset ? ";
	final String VIEW_ALL_PROFESSOR_COUNT  = " SELECT count(*) AS row_count FROM professor_tb ";
	
	// 학생, 교수 검색 쿼리
	
	
	// 등록/장학금 관련 쿼리
	final String SEND_ALL_TUITION_TYPE2 = " INSERT INTO tuition_tb (student_id, tui_year, semester, tui_amount, sch_type, sch_amount) SELECT s.id,2023, 1, 4868500, sh.type, sh.max_amount FROM student_tb AS s LEFT JOIN stu_sch_tb AS sc ON s.id = sc.student_id LEFT JOIN scholarship_tb as sh ON sc.sch_type = sh.type LEFT JOIN stu_stat_tb as st ON s.id = st.student_id WHERE st.status = '재학' ";
	final String GET_ALL_TUITION_LIST = " SELECT * FROM tuition_tb ";
	final String GET_STUDENT_STATUS = " SELECT * FROM stu_stat_tb ";
	
	// 휴학 신청 목록 쿼리
	final String GET_BREAK_LIST = " SELECT * FROM break_app_tb ";
	final String PROCESS_BREAK = " UPDATE break_app_tb SET status = '완료' WHERE student_id = ? ";
	
	// 등록금 전송 쿼리
	final String SEND_TUITION = " INSERT INTO tuition_tb() VALUES (?, ?, ?, ?, ?, ?, ?) ";
	
	@Override
	public Staff viewMyInfo(int userId) {
		Staff staff = null;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(STAFF_INFO)) {
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				conn.commit();
				if(rs.next()) {
					staff = Staff.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.hireDate(rs.getDate("hire_date"))
							.build();
							
				}
				
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public void changePassword(String password, int userId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(CHANGE_PASSWORD)) {
				pstmt.setString(1, password);
				pstmt.setInt(2, userId);
				pstmt.executeUpdate();
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void changeInfomation(String address, int tel, String email, int userId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(CHANGE_MY_INFO)){
				pstmt.setString(1, address);
				pstmt.setInt(2, tel);
				pstmt.setString(3, email);
				pstmt.setInt(4, userId);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				System.out.println("rollback");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public List<Student> viewAllStudent(int limit, int offset) {
		
		List<Student> studentList = new ArrayList<Student>();
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(VIEW_ALL_STUDENT)){
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Student student = Student.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date"))
						.gender(rs.getString("gender"))
						.address(rs.getString("address"))
						.tel(rs.getString("tel"))
						.email(rs.getString("email"))
						.deptId(rs.getInt("dept_id"))
						.grade(rs.getInt("grade"))
						.entranceDate(rs.getDate("entrance_date"))
						.graduationDate(rs.getDate("graduation_date"))
						.build();
				studentList.add(student);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public List<Professor> viewAllProfessor(int limit, int offset) {
		
		List<Professor> professorList = new ArrayList<Professor>();
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(VIEW_ALL_PROFESSOR)){
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Professor professor = Professor.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date"))
						.gender(rs.getString("gender"))
						.address(rs.getString("address"))
						.tel(rs.getString("tel"))
						.email(rs.getString("email"))
						.deptId(rs.getInt("dept_id"))
						.hireDate(rs.getDate("hire_date"))
						.build();
				professorList.add(professor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professorList;
	}
	
	@Override
	public int getAllProfessorLectureCount() {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(VIEW_ALL_PROFESSOR_COUNT)){
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					rowCount = rs.getInt(1);
				}
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	@Override
	public int getAllStudentLectureCount() {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(VIEW_ALL_STUDENT_COUNT)){
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					rowCount = rs.getInt(1);
				}
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public void viewStudentByIdandNumber() {
		
	}

	@Override
	public void viewProfessorByIdandNumber() {
		
	}

	@Override
	public void addStudent(String name, Date birthDate, String gender, String address, String tel, String email, int deptId, Date entraceDate) {
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADD_STUDENT)){
				pstmt.setString(1, name);
				pstmt.setDate(2, birthDate);
				pstmt.setString(3, gender);
				pstmt.setString(4, address);
				pstmt.setString(5, tel);
				pstmt.setString(6, email);
				pstmt.setInt(7, deptId);
				pstmt.setDate(8, entraceDate);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override 
	public void addProfessor(String name, Date birthDate, String gender, String address, String tel, String email, int deptId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADD_PROFESSOR)){
				pstmt.setString(1, name);
				pstmt.setDate(2, birthDate);
				pstmt.setString(3, gender);
				pstmt.setString(4, address);
				pstmt.setString(5, tel);
				pstmt.setString(6, email);
				pstmt.setInt(7, deptId);
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount);
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStaff(String name, Date birthDate, String gender, String address, String tel, String email) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADD_STAFF)){
				pstmt.setString(1, name);
				pstmt.setDate(2, birthDate);
				pstmt.setString(3, gender);
				pstmt.setString(4, address);
				pstmt.setString(5, tel);
				pstmt.setString(6, email);
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount);
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BreakApp> viewAllBreak() {
		List<BreakApp> breakList = new ArrayList<BreakApp>();
		BreakApp breakApp = null;
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(GET_BREAK_LIST)){
				ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
					breakApp = BreakApp.builder()
							.studentId(rs.getInt("student_id"))
							.studentGrade(rs.getInt("student_grade"))
							.fromYear(rs.getInt("from_year"))
							.fromSemester(rs.getInt("from_semester"))
							.toYear(rs.getInt("to_year"))
							.toSemester(rs.getInt("to_semester"))
							.type(rs.getString("type"))
							.appDate(rs.getDate("app_date"))
							.status(rs.getString("status"))
							.build();
					System.out.println("breakApp in Repository : " + breakApp.toString());
					breakList.add(breakApp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return breakList;
	}
	
	@Override
	public void processBreak(int userId) {
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(PROCESS_BREAK)){
				pstmt.setInt(1, userId);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCollege() {
		
	}

	@Override
	public void addDepartment() {
		
	}

	@Override
	public void addClassRoom() {
		
	}

	@Override
	public void addClass() {
		
	}

	@Override
	public void addtuition(int userId, int type, int maxAmount) {
		
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SEND_TUITION)){
				pstmt.setInt(1, userId);
				pstmt.setInt(2, 2023);
				pstmt.setInt(3, 1);
				pstmt.setInt(4, 4868500);
				pstmt.setInt(5, type);
				pstmt.setInt(6, maxAmount);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Notice> viewNotice() {
		return null;
	}

	@Override
	public void viewAcademicSchedule() {
		
	}



}
