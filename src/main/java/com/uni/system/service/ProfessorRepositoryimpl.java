package com.uni.system.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.Subject;

public class ProfessorRepositoryimpl implements ProfessorRepository {

	@Override
	public void viewMyInfo() {

	}

	@Override
	public void changePassword(int id, int password) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = " UPDATE user_tb SET password = ? WHERE id = ? ";
			conn = DriverManager.getConnection(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, password);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<Subject> viewAllSubject() {
		return null;
	}

	@Override
	public List<Subject> viewSubjectById(int id) {
		return null;
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
