package com.uni.system.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> ffd718c7aab878faa863fca8e696321ad0c1861a
=======
>>>>>>> 1c98975819d24d9465e16590ce57fea170488345

	private static DataSource dataSource;

	static {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/six");
		} catch (Exception e) {
			System.out.println("DBUtil 초기화 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		return dataSource.getConnection();
	}
<<<<<<< HEAD

=======
	
	
	
>>>>>>> 1c98975819d24d9465e16590ce57fea170488345
}
