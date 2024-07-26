package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.NoticeList;
import com.uni.system.repository.model.Schedule;

public interface ScheduleRepository {
	
	List<Schedule> selectAllscheduleTable();
	

	
}
