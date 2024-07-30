package com.uni.system.service;

import com.uni.system.repository.interfaces.ScoreRepository;

public class ScoreRepositoryImpl implements ScoreRepository{
	
	final String GET_MY_SCORE  = " SELECT * FROM stu_sub_detail_tb WHERE student_id = ? ";
	final String GET_MY_SCORE_BY_SEMESTER = " SELECT * FROM stu_sub_detail_tb WHERE student_id = ? ";
	final String GET_MY_SCORE_CUMLATIVE = "";
	
	@Override
	public void viewThisSemester(int userId, int semester) {
		
		
	}

	@Override
	public void viewBySemester(int userId, int semester) {
		
	}

	@Override
	public void cumulative(int userId) {
		
		
	}

}
