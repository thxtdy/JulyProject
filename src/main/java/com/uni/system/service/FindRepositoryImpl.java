package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uni.system.repository.interfaces.FindRepository;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.utils.DBUtil;

public class FindRepositoryImpl implements FindRepository{

	@Override
	public UserDTO findStudentID(String userName, String email) {
		UserDTO dto = null;
		final String FIND_STUDENT_ID = " SELECT id FROM student_tb WHERE name = ? AND email = ? ";
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(FIND_STUDENT_ID)){
				pstmt.setString(1, userName);
				pstmt.setString(2, email);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = UserDTO.builder()
							.id(rs.getInt("id"))
							.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public UserDTO findStaffID(String userName, String email) {
		UserDTO dto = null;
		final String FIND_STAFF_ID = " SELECT id FROM staff_tb WHERE name = ? AND email = ? ";
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(FIND_STAFF_ID)){
				pstmt.setString(1, userName);
				pstmt.setString(2, email);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = UserDTO.builder()
							.id(rs.getInt("id"))
							.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public UserDTO findProfessor(String userName, String email) {
		UserDTO dto = null;
		final String FIND_PROFESSOR_ID = " SELECT id FROM professor_tb WHERE name = ? AND email = ? ";
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(FIND_PROFESSOR_ID)){
				pstmt.setString(1, userName);
				pstmt.setString(2, email);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = UserDTO.builder()
							.id(rs.getInt("id"))
							.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public UserDTO findMyPW(int userId) {
		UserDTO dto = null;
		final String FIND_PASSWORD = " SELECT password FROM user_tb WHERE id = ? ";
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(FIND_PASSWORD)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = UserDTO.builder()
							.password(rs.getString("password"))
							.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
