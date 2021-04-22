package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // DB클래스 = try-catch

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속 성공");

			Statement st = con.createStatement();

			String sql = "INSERT INTO tblMember VALUES(6,'장보리', 27, '서울시 강남구 청담동', '01022222222')";

			int result = st.executeUpdate(sql);
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			
			sql = "UPDATE tblMember " 
			      +	"SET age = 31, phone = '01098765432' " 
				  + "WHERE no = 6";
			
			// 나이 31, 전화번호 01098765432로 수정하는 기능 구현
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
