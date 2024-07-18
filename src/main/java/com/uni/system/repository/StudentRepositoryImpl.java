package com.uni.system.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.uni.system.model.Student;
import com.uni.system.repository.interfaces.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository {

	private DataSource dataSource;
	
	public StudentRepositoryImpl() {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/MyDB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudentByStudentname(String studentname) {
		String sql = " select * from student_tb where id = ? " ;
		Student student = null;
		
		try(Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, studentname);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setBirthDate(rs.getDate("birthDate"));
					student.setGender(rs.getString("gender"));
					student.setTel(rs.getString("tel"));
					student.setEmail(rs.getString("email"));
					student.setDeptId(rs.getInt("detpId"));
					student.setGrade(rs.getInt("grade"));
					student.setSemester(rs.getInt("semester"));
					student.setEntranceDate(rs.getDate("entranceDate"));
					student.setGraduationDate(rs.getDate("graduationDate"));
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return student;
	}
	


}
