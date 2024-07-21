package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.SubjectLectureList;

public interface SubjectRepository {
		
	List<SubjectLectureList> selectByYearAndSemester(int year, int semester);
	
	// 연도-학기-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<SubjectLectureList> selectBySemesterAndDeptAndName(int year, int semester, int deptId);
	
	// syllabus 강의 이름
	// 연도-학기-강의구분-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<SubjectLectureList> selectBySemesterAndDeptAndNameAndTpye(int year, int semester, int deptId, String lectureName);
}
