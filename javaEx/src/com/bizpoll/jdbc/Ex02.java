package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex02 {
	
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // DB클래스 = try-catch

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속 성공");

			Statement st = con.createStatement();

			String sql = "SELECT * FROM tblMember";

			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				
				System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
