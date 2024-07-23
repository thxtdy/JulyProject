package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.NoticeRepository;
import com.uni.system.repository.model.NoticeList;
import com.uni.system.utils.DBUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class NoticeRepositoryImpl implements NoticeRepository {
	
	private static final String SELECT_ALL_NOTICE = " SELECT * FROM notice_tb ";

	

	@Override
	public List<NoticeList> selectAllTable() {
		List<NoticeList> noticeList = new ArrayList<NoticeList>();
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_NOTICE)){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					NoticeList noticeLists = NoticeList.builder()
							.id(rs.getInt("id"))
							.category(rs.getString("category"))
							.title(rs.getString("title"))
							.createdTime(rs.getTimestamp("created_time"))
							.views(rs.getInt("views"))
							.build();
					noticeList.add(noticeLists);
							}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}



}
