package com.uni.system.repository.interfaces;

import com.uni.system.model.Student;

public interface StudentRepository {
	
	Student getStudentByStudentname(String username);

}
