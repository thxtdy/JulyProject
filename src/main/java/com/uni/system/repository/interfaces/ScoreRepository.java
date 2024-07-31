package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.StuSub;

public interface ScoreRepository {
	
	List<StuSub> viewThisSemester(int userId);
	void viewBySemester(int userId, int semester);
	void cumulative(int userId);
}
