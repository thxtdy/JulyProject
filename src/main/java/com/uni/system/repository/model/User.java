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
public class User {
//
	private int studentId;
	private int tuiYear;
	private int semester;
	private int tuiAmount;
	private int schType;
	private int schAmount;
	private int status;

}
