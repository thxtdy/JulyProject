package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class SugangDetail {
	
	private int subjectId; // 수업 번호
	private String subName; // 교과목 명
	private int subYear; // 수업 연도
	private int semester; // 수업 학기
	private int grades; // 학점
	private String type; // 전공
	private String subDay; // 강의 시간
	private int startTime; // 강의 시간
	private int endTime; // 강의 시간
	private String roomId; // 강의실
	private String collegeName; // 예(공과대학)
	private String deptName; // 소속
	private String professorName; // 교수 이름
	private String tel; // 교수 번호
	private String email; // 교수 이메일
}
