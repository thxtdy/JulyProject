package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.StuSub;
import com.uni.system.repository.model.StuSubDetail;
import com.uni.system.repository.model.Subject;
import com.uni.system.utils.DBUtil;

public class ProfessorRepositoryimpl implements ProfessorRepository {
	
	// 교수 정보 쿼리, 교수가 담당하고 있는 강의 쿼리, 교수의 수업을 신청한 학생 조회 쿼리
	final String PROFESSOR_INFO = " SELECT p.*, c.name as college, d.name as department FROM college_tb AS c LEFT JOIN department_tb AS d ON c.id = d.college_id LEFT JOIN professor_tb as p on p.dept_id = d.id where p.id = ? ";
	final String PROFESSOR_CLASS = " SELECT s.* FROM subject_tb AS s LEFT JOIN professor_tb AS p ON s.professor_id = p.id WHERE p.id = ? ";
	
	// 교수 수업을 신청한 학생들의 모든 정보를 뽑아오겠다. WHERE절은 subject_id를 가지고 옴(stu_sub_tb 사용)
	final String GET_MY_STUDENT_BY_SUBJECT_ID = " SELECT stu.name AS student_name, sub.subject_id, dept.name AS department, sub.* , detail.* FROM stu_sub_tb AS sub LEFT JOIN student_tb AS stu ON sub.student_id = stu.id LEFT JOIN department_tb AS dept ON stu.dept_id = dept.id LEFT JOIN stu_sub_detail_tb AS detail ON sub.id = detail.id WHERE sub.subject_id = ? ";
	
	// 교수 수업을 신청한 학생의 ID의 정보를 뽑아오겠다. WHERE절은 student_id
	final String GET_MY_STUDENT_BY_STUDENT_ID = " SELECT stu.name AS student_name,sub.subject_id, dept.name AS department, sub.* , detail.* FROM stu_sub_tb AS sub LEFT JOIN student_tb AS stu ON sub.student_id = stu.id LEFT JOIN department_tb AS dept ON stu.dept_id = dept.id LEFT JOIN stu_sub_detail_tb AS detail ON sub.id = detail.id WHERE stu.id = ? ";
	
	// 교수 수업을 신청한 학생들의 모든 정보를 다 뽑겠다. 근데 이것은 기입/수정을 가리기 위한 쿼리이다 (stu_sub_detail_tb 사용).
	final String GET_MY_STUDENT_DETAIL = " SELECT stu.name, dept.name AS department, detail.* FROM stu_sub_detail_tb AS detail LEFT JOIN stu_sub_tb AS sub ON detail.id = sub.id LEFT JOIN student_tb AS stu ON detail.student_id = stu.id LEFT JOIN department_tb AS dept ON stu.dept_id = dept.id WHERE sub.subject_id = ? ";
	
	// 교수가 학생의 점수를 기입하는 쿼리입니다.
	final String EVALUATION_STUDENT = " INSERT INTO stu_sub_detail_tb (id, student_id, subject_id, absent, lateness, homework, mid_exam, final_exam, converted_mark) SELECT sub.id, sub.student_id, sub.subject_id, ?, ?, ?, ?, ?, ? FROM stu_sub_tb AS sub WHERE sub.student_id = ? AND sub.subject_id = ? ";
	// 교수가 학생의 학점을 관리하는 쿼리입니다.
	final String EDIT_STUDENT_GRADE = " UPDATE stu_sub_tb as sub SET sub.grade = ? WHERE sub.student_id = (SELECT student_id FROM stu_sub_detail_tb WHERE student_id = ?) ";
	// 교수가 학생의 평가 내역을 수정하는 쿼리입니다.
	final String EDIT_STUDENT_SCORE = " UPDATE stu_sub_detail_tb AS detail, stu_sub_tb AS sub SET detail.absent = ?, detail.lateness = ?, detail.homework = ?, detail.mid_exam = ?, detail.final_exam = ?, detail.converted_mark = ?, sub.grade = ? WHERE detail.student_id = ? AND sub.student_id = ? AND sub.subject_id = ? ";
	
	@Override
	public Professor viewMyInfo(int userId) {
		Professor professor = null;
		try (Connection conn = DBUtil.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(PROFESSOR_INFO)) {
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					professor = Professor.builder().id(rs.getInt("id")).name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
							.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
							.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date"))
							.college(rs.getString("college")).department(rs.getString("department")).build();
				}

			} catch (Exception e) {

			}
		} catch (Exception e) {
		}
		return professor;
	}
	
	@Override
	public List<Subject> viewSubjectById(int userId) {
		List<Subject> myList = new ArrayList<Subject>();
		Subject subject = null;
		try (Connection conn = DBUtil.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(PROFESSOR_CLASS)) {
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					subject = Subject.builder().id(rs.getInt("id")).name(rs.getString("name"))
							.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
							.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
							.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time"))
							.grades(rs.getInt("grades")).capacity(rs.getInt("capacity"))
							.numOfStudent(rs.getInt("num_of_student")).build();
					myList.add(subject);
					System.out.println("교수 담당 : " + subject.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myList;
	}
	
	@Override
	public List<StuSub> viewMyStudent(int subjectId) {
		StuSub student = null;
		List<StuSub> studentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(GET_MY_STUDENT_BY_SUBJECT_ID)){
				pstmt.setInt(1, subjectId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					student = StuSub.builder()
							.studentId(rs.getInt("student_id"))
							.subjectId(rs.getInt("subject_id"))
							.studentName(rs.getString("student_name"))
							.department(rs.getString("department"))
							.absent(rs.getInt("absent"))
							.lateness(rs.getInt("lateness"))
							.homework(rs.getInt("homework"))
							.midExam(rs.getInt("mid_exam"))
							.finalExam(rs.getInt("final_exam"))
							.convertedMark(rs.getInt("converted_mark"))
							.build();
					studentList.add(student);
					System.out.println(studentList.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
	

	@Override
	public List<StuSubDetail> viewMyStudentDetail(int subjectId) {
		StuSubDetail studentDetail = null;
		List<StuSubDetail> studentDetailList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(GET_MY_STUDENT_DETAIL)){
				pstmt.setInt(1, subjectId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					studentDetail = StuSubDetail.builder()
							.id(rs.getInt("id"))
							.studentId(rs.getInt("student_id"))
							.studentName(rs.getString("name"))
							.department(rs.getString("department"))
							.absent(rs.getInt("absent"))
							.lateness(rs.getInt("lateness"))
							.homework(rs.getInt("homework"))
							.midExam(rs.getInt("mid_exam"))
							.finalExam(rs.getInt("final_exam"))
							.convertedMark(rs.getInt("converted_mark"))
							.build();
					studentDetailList.add(studentDetail);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDetailList;
	}
	
	@Override
	public List<StuSub> getMyStudentInfo(int userId) {
		List<StuSub> studentList = new ArrayList<>();
		StuSub student = null;
		try (Connection conn = DBUtil.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(GET_MY_STUDENT_BY_STUDENT_ID)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					student = StuSub.builder()
					.studentId(rs.getInt("student_id"))
					.subjectId(rs.getInt("subject_id"))
					.studentName(rs.getString("student_name"))
					.department(rs.getString("department"))
					.absent(rs.getInt("absent"))
					.lateness(rs.getInt("lateness"))
					.homework(rs.getInt("homework"))
					.midExam(rs.getInt("mid_exam"))
					.finalExam(rs.getInt("final_exam"))
					.convertedMark(rs.getInt("converted_mark"))
					.build();
						studentList.add(student);	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	@Override
	public void editEvaluation(int absent, int lateness, int homework, int midExam, int finalExam, int converted, String grade, int subStudentId, int detailStudentId, int subjectId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(EDIT_STUDENT_SCORE)){
				pstmt.setInt(1, absent);
				pstmt.setInt(2, lateness);
				pstmt.setInt(3, homework);
				pstmt.setInt(4, midExam);
				pstmt.setInt(5, finalExam);
				pstmt.setInt(6, converted);
				pstmt.setString(7, grade);
				pstmt.setInt(8, subStudentId);
				pstmt.setInt(9, detailStudentId);
				pstmt.setInt(10, subjectId);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void evaluationStudent(int absent, int lateness, int homework, int midExam, int finalExam, int converted, int studentId, int subjectId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(EVALUATION_STUDENT)){
				System.out.println("absend : " + absent + " lateness : " + lateness + " homework : " + homework + " midExam : " + midExam + " finalExam : " + finalExam  + " converted : " + converted + " studentId  : " + studentId  + " subjectId : " + subjectId);
				pstmt.setInt(1, absent);
				pstmt.setInt(2, lateness);
				pstmt.setInt(3, homework);
				pstmt.setInt(4, midExam);
				pstmt.setInt(5, finalExam);
				pstmt.setInt(6, converted);
				pstmt.setInt(7, studentId);
				pstmt.setInt(8, subjectId);
				int rowCount = pstmt.executeUpdate();
				System.out.println("rowCount : " + rowCount);
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addGradeByStudent(String grade, int userId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(EDIT_STUDENT_GRADE)){
				pstmt.setString(1, grade);
				pstmt.setInt(2, userId);
			    int rowCount = pstmt.executeUpdate();
				conn.commit();
				System.out.println("학점 기입 쿼리 확인용 rowCount : " + rowCount);
			} catch (Exception e) {
				conn.rollback();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Evaluation> viewEvaluationById(int id) {
		return null;
	}

	@Override
	public List<Notice> viewNotice() {
		return null;
	}

	@Override
	public List<Schedule> viewAcademicSchedule() {
		return null;
	}

	@Override
	public void addAcademicSchedule() {

	}

}
