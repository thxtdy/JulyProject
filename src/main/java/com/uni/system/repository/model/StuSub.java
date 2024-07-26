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
	private String department;
	private int subjectId;
	private int absent;
	private int lateness;
	private int homework;
	private int midExam;
	private int finalExam;
	private int convertedMark;
	private String studentName;
	private String studentGrade;
	private String grade;
	private int completeGrade;

}
