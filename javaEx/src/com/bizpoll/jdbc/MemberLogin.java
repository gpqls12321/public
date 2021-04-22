package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberLogin {

	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pw = "1234";

	List<MemberDTO> memList = new ArrayList<>();

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection con = null;

	public List<MemberDTO> memLogin(int inputNo, String inputName) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * " + 
					"FROM tblMember " + 
					"WHERE no = ? AND name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inputNo);
			pstmt.setString(2, inputName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);

				memList.add(mDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return memList;
	}
}
