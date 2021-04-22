package com.bizpoll.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bizpoll.jdbc.MemberDTO;

public class MemberSearch {
	
//	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	String user = "scott";
//	String pw = "1234";
	
	List<MemberDTO2> memList = new ArrayList<>();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs  = null;
	
	public List<MemberDTO2> memSearch(String inputName) {
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection(url, user, pw);
			con = DBManager.getConnection();
			
			String keyWord = "%" + inputName + "%";
			String sql = "SELECT * FROM tblMember WHERE name LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyWord);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				MemberDTO2 mDto = new MemberDTO2(no, name, age, addr, phone);

				memList.add(mDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt,rs);
		}
		return memList;
	}
}
