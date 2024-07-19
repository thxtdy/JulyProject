package com.uni.system.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.Query;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.User;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.utils.DBUtil;

public class UserRepositoryImpl implements UserRepository {
	
	final String SELECT_USER_BY_PASSWORD = " SELECT * FROM user_tb WHERE id = ? AND password = ? " ;

	@Override
	public UserDTO getUserbyUsername(int username, String password) {
		UserDTO user = null;
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_USER_BY_PASSWORD);
			pstmt.setInt(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = UserDTO.builder()
						.id(rs.getInt("id"))
					   .password(rs.getString("password"))
					   .userRole(rs.getString("user_role"))
					   .build();
					   
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public UserDTO getUserbyRole(String userRole) {
		// TODO Auto-generated method stub
		return null;
	}


				
		

}
