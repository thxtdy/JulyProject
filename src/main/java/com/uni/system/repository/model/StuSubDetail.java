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
public class StuSubDetail {
	
	private int id;				// primary key 입니다.
	private int studentId;		// 학생 번호(ID) 입니다.
	private String studentName; // 학생 이름 입니다.
	private String department;  // 학생 소속 입니다.
	private int subjectId;		// 과목 번호(ID) 입니다.
	private int absent;			// 결석이라는 뜻입니다.
	private int	lateness;		// 지각이라는 뜻입니다.
	private int homework;		// 과제점수입니다.
	private int midExam;		// 중간 시험입니다.
	private int finalExam;		// 기말 시험입니다.
	private int convertedMark;	// 환산 점수입니다.

}
