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
	void changeInfomation(String address, int tel, String email, int userId);
	
	List<Subject> viewSubjectById(int userId); // 내가 관리하는 강의 보기
	// 교수 수업을 신청한 학생들의 목록만 보여주겠습니다. (학생 ID, 학생 이름, 학과, 모든 디테일의 정보) stu_sub_tb
	List<StuSub> viewMyStudent(int subjectId);
	
	// 학생 평가 기입/수정을 나누기 위해서 stu_sub_detail_tb의 여부에 따라 판단. 학생 ID, 학생 이름, 학생 과,
	List<StuSubDetail> viewMyStudentDetail(int subjectId);
	
	// 학생을 평가하기 위해 학생의 정보를 evaluationStudent.jsp로 보내는
    List<StuSub> getMyStudentInfo(int userId);
	
    // 학생을 평가한 내역을 수정
    void editEvaluation(int absent, int lateness, int homework, int midExam, int finalExam, int converted, String grade, int subStudentId, int detailStudentId, int subjectId);
    
	// 교수 수업 - 조회를 눌렀을때 학생들의 세부 사항을 보여주겠습니다. (학생 이름, 결석, 지각, 과제, 중간, 기말, 합산)
	
	
	// 수업
	void evaluationStudent(int absent, int lateness, int homework, int midExam, int finalExam, int converted, int studentId, int subjectId); // 학생 평가해버리기
	void addGradeByStudent(String grade, int userId);
	
	List<Evaluation> viewEvaluationById(int id); // 내 강의 평가 (교수 ID)
	
	// 학사정보
	List<Notice> viewNotice(); // 공지사항
	List<Schedule> viewAcademicSchedule(); // 학사일정
	void addAcademicSchedule(); // 학사일정 등록
	
	
}
