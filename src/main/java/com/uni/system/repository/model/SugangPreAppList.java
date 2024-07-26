package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class SugangPreAppList {
	private int haksuNum;
	private String lectureName;
	private String professorName;
	private int grades;
	private String subDay;
	private int startTime;
	private int endTime;
	private String roomId;
	private int numOfStudent;
	private int capacity;
}
