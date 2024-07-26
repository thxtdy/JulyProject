package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.StuSub;
import com.uni.system.repository.model.StuSubDetail;
import com.uni.system.repository.model.Subject;
import com.uni.system.repository.model.SugangColumn;

public interface ProfessorRepository {
	
	
	
	// MY 페이지
	Professor viewMyInfo(int userId); // 내 정보 보기
	
	// 수업
	List<Subject> viewAllSubject(); // 전체 강의 조회
	List<Subject> viewSubjectById(int id); // 내 강의 조회 (파라미터 설계, ID == 교수 ID)
	List<StuSub> viewMyStudent(int subjectId); // 내 강의를 신청한 학생들 명단 조회
	List<StuSub> viewMyStudentByUserId(int userId);
	void evaluationStudent(int absent, int lateness, int homework, int midExam, int finalExam, int converted, int studentId, int subjectId); // 학생 평가해버리기
	
	List<Evaluation> viewEvaluationById(int id); // 내 강의 평가 (교수 ID)
	
	// 학사정보
	List<Notice> viewNotice(); // 공지사항
	List<Schedule> viewAcademicSchedule(); // 학사일정
	void addAcademicSchedule(); // 학사일정 등록
	
	
}
