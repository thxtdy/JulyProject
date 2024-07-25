package com.uni.system.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeList {
	
	int id;
	String category;
	String title;
	String content;
	Timestamp createdTime;
	int views;

}
