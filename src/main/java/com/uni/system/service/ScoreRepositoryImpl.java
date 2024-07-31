package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.ScoreRepository;
import com.uni.system.repository.model.StuSub;
import com.uni.system.utils.DBUtil;

public class ScoreRepositoryImpl implements ScoreRepository{
	
	final String GET_MY_SCORE  = "SELECT detail.*, subject.name AS subject_name, sub.grade FROM stu_sub_tb AS sub LEFT JOIN stu_sub_detail_tb as detail ON sub.id = detail.id LEFT JOIN subject_tb AS subject ON sub.subject_id = subject.id WHERE sub.student_id = ? ";
	final String GET_MY_SCORE_BY_SEMESTER = " SELECT * FROM stu_sub_detail_tb WHERE student_id = ? ";
	final String GET_MY_SCORE_CUMLATIVE = "";
	
	@Override
	public List<StuSub> viewThisSemester(int userId) {
		List<StuSub> scoreList = new ArrayList<>();
		StuSub score = null;
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(GET_MY_SCORE)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					score = StuSub.builder()
							.studentId(rs.getInt("student_id"))
							.subjectName(rs.getString("subject_name"))
							.absent(rs.getInt("absent"))
							.lateness(rs.getInt("lateness"))
							.homework(rs.getInt("homework"))
							.midExam(rs.getInt("mid_exam"))
							.finalExam(rs.getInt("final_exam"))
							.grade(rs.getString("grade"))
							.build();
					scoreList.add(score);
				}
			} catch (Exception e) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scoreList;
	}

	@Override
	public void viewBySemester(int userId, int semester) {
		
	}

	@Override
	public void cumulative(int userId) {
		
		
	}

}
