package com.bizpoll.jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDAO {
	
	public List<MemberDTO> memberDao() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con = DriverManager.getConnection(url, user, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
