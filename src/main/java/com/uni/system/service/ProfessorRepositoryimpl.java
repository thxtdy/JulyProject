package com.uni.system.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.Subject;
import com.uni.system.utils.DBUtil;

public class ProfessorRepositoryimpl implements ProfessorRepository {

	@Override
	public void viewMyInfo() {

	}

	@Override
	public void changePassword(int id, int password) {
		String sql = "UPDATE user_tb SET password = ? WHERE id = ?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, password);
			pstmt.setInt(2, id);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("비밀번호 변경 완료");
			} else {
				System.out.println("해당 ID를 가진 사용자가 없습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
