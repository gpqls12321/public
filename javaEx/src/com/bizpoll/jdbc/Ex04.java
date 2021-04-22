package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex04 {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("접속 성공");
			
			String sql = "UPDATE tblMember SET age = ?, phone = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 35);
			pstmt.setString(2, "01065656565");
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
