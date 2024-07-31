package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StuSub {
	
	private int id;
	private int studentId;
	private int subjectId;
	private String subjectName;
	private String studentName;
	private String department;
	private int absent;			// 결석이라는 뜻입니다.
	private int	lateness;		// 지각이라는 뜻입니다.
	private int homework;		// 과제점수입니다.
	private int midExam;		// 중간 시험입니다.
	private int finalExam;		// 기말 시험입니다.
	private int convertedMark;	// 환산 점수입니다.

	private String grade;
	private int completeGrade;
}
