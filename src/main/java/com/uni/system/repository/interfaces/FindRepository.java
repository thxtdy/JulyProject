package com.uni.system.repository.interfaces;

import com.uni.system.repository.model.UserDTO;

public interface FindRepository {
	
	UserDTO findStudentID(String userName, String email);
	UserDTO findStaffID(String userName, String email);
	UserDTO findProfessor(String userName, String email);
	UserDTO findMyPW(int userId);
	
	
}
