package com.uni.system.repository.interfaces;

public interface ScoreRepository {
	
	void viewThisSemester(int userId, int semester);
	void viewBySemester(int userId, int semester);
	void cumulative(int userId);
}
