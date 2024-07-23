package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.NoticeList;

public interface NoticeRepository {
	
	List<NoticeList> selectAllTable();
	
}
