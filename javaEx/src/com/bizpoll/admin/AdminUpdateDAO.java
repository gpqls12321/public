package com.bizpoll.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminUpdateDAO {

	List<AdminDTO> adminInsert = new ArrayList<>();

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result = 0;
	boolean x = false;
	int succ = 0;

	public int AdminUpdate(AdminDTO aDto) {

		try {
			con = DBManager.getConnection();

			String sql = "UPDATE adminMember SET pwd = ?, phone = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aDto.getPwd());
			pstmt.setString(2, aDto.getPhone());
			pstmt.setString(3, aDto.getId());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return succ;

	}
}
