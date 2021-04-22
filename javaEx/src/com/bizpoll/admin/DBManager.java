/*
 * *******************************************
 * @Source : DBManager.java
 * @description : Connection 객체를 얻어오고 사용이 끝난 리소스를 해제하는 클래스
 * *******************************************
 * DATE			AUTHOR			DESCRIPTION
 * -------------------------------------------
 * 2021.03.31   한혜빈			최초작성
 * 2021.**.**   한혜빈			회원가입 기능 추가 (ex)
 */

package com.bizpoll.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Singleton 클래스 : 인스턴스를 하나만 만들어서 사용하는 방법
public class DBManager {
	private static Connection con;

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USER = "scott";
	private static final String PASS = "1234";

	private DBManager() { // 다른 쪽에서 객체를 생성하지 못하도록 막는 것.

	}

	public static Connection getConnection() {
		con = null;
		if (con == null) {
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
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

	public static void close(PreparedStatement pstmt, ResultSet rs) { // 같은 메서드 이름이어도 매개변수 갯수 다르면 사용 가능 
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
}
