package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.model.BreakApp;
import com.uni.system.repository.model.Grade;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Subject;
import com.uni.system.utils.DBUtil;

public class StudentRepositoryImpl implements StudentRepository{
	
	Query query;
	
	@Override
	public void viewMyInfo() {
		
	}

	@Override
	public void changePassword() {
		
	}

	@Override
	public void addBreak() {
		
	}

	@Override
	public List<BreakApp> viewAllBreak() {
		return null;
	}

	@Override
	public void viewTuition() {
		
	}

	@Override
	public void tuitionbill() {
		
	}

	@Override
	public List<Subject> viewAllClass() {
		List<Subject> subjectList = new ArrayList<Subject>();
		// SELECT 
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query.VIEW_ALL_CLASS);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Subject subject = new Subject().builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.professorId(rs.getInt("professorId"))
						.roomId(rs.getString("roomId"))
						.deptId(rs.getInt("deptId"))
						.type(rs.getString("type"))
						.subYear(rs.getInt("subYear"))
						.semester(rs.getInt("semester"))
						.subDay(rs.getString("subDay"))
						.startTime(rs.getInt("startTime"))
						.endTime(rs.getInt("endTime"))
						.grades(rs.getInt("grade"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("numOfStudent"))
						.build();
				subjectList.add(subject);
				
			}
			
		} catch (Exception e) {

		}
		return subjectList;
	}

	@Override
	public void viewAllClassSchedule() {
		
	}

	@Override
	public void addBeforehandToDoCourse() {
		
	}

	@Override
	public void addToDoCourse() {
		
	}

	@Override
	public void viewToDoCourse() {
		
	}

	@Override
	public void viewScore() {
		
	}

	@Override
	public void viewScoreBySemester() {
		
	}

	@Override
	public List<Grade> viewAllScore() {
		return null;
	}

	@Override
	public List<Notice> viewNotice() {
		return null;
	}

	@Override
	public void viewAcademicSchedule() {
		
	}

}
