package com.uni.system.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.Subject;
import com.uni.system.utils.DBUtil;

public class ProfessorRepositoryimpl implements ProfessorRepository {
	
	final String PROFESSOR_INFO = " SELECT p.*, c.name as college, d.name as department FROM college_tb as c LEFT JOIN department_tb AS d ON c.id = d.college_id LEFT JOIN professor_tb as p on p.dept_id = d.id where p.id = ? ";
	final String PROFESSOR_CLASS = " SELECT s.* FROM subject_tb AS s LEFT JOIN professor_tb AS p ON s.professor_id = p.id WHERE p.id = ? ";
	
	@Override
	public Professor viewMyInfo(int userId) {
		Professor professor = null;
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(PROFESSOR_INFO)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					professor = Professor.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.deptId(rs.getInt("dept_id"))
							.hireDate(rs.getDate("hire_date"))
							.college(rs.getString("college"))
							.department(rs.getString("department"))
							.build();
				}
				
			} catch (Exception e) {
				
			}
		} catch (Exception e) {

		}
		return professor;
	}

	@Override
	public List<Subject> viewAllSubject() {
		

		
		return null;
	}

	@Override
	public List<Subject> viewSubjectById(int userId) {
		List<Subject> myList = new ArrayList<Subject>();
		Subject subject = null;
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(PROFESSOR_CLASS)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					subject = Subject.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.professorId(rs.getInt("professor_id"))
							.roomId(rs.getString("room_id"))
							.deptId(rs.getInt("dept_id"))
							.type(rs.getString("type"))
							.subYear(rs.getInt("sub_year"))
							.semester(rs.getInt("semester"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.grades(rs.getInt("grades"))
							.capacity(rs.getInt("capacity"))
							.numOfStudent(rs.getInt("num_of_student"))
							.build();
					myList.add(subject);
					System.out.println("교수 담당 : "+ subject.toString());
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
