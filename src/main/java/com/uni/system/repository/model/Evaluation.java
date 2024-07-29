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
public class Evaluation {
	// 학생이 교수를 평가하는 DTO입니다.
	private int evaluationId;
	private int studentId;
	private int subjectId;
	private int answer1;
	private int answer2;
	private int answer3;
	private int answer4;
	private int answer5;
	private int answer6;
	private int answer7;
	private String improvements;
	
	
}
