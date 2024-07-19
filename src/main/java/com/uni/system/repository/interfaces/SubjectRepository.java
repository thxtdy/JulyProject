package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.Subject;

public interface SubjectRepository {
		
	// 연도-학기-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<Subject> selectBySemesterAndDeptAndName();
	
	// 연도-학기-강의구분-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<Subject> selectBySemesterAndDeptAndNameAndTpye();
}
