package com.uni.system.repository.interfaces;

public interface TuitionRepository {
	
	void checkTuition(int userId, int type, int maxAmount);
	
}
