package com.bizpoll.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

	List<AdminDTO> adminInsert = new ArrayList<>();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result = 0;
	boolean x = false;
	int succ = 0;

	public int memInsert(String inputID, String inputPWD, String inputName, String inputPhone) {
		try {
			con = DBManager.getConnection();
			
			String sql = "INSERT INTO adminMember VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputID);
			pstmt.setString(2, inputPWD);
			pstmt.setString(3, inputName);
			pstmt.setString(4, inputPhone);
			
			result = pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;	
	}
	
//	public boolean check(String inputID) {
//		try {
//			con = DBManager.getConnection();
//			String sql = "SELECT * FROM adminMember WHERE id = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, inputID);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) x = true;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return x;  
//	}
	
	public boolean adminIdCheck(String id) {
		int resultCnt = 0;
		boolean useYN = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			
			String sql = "SELECT COUNT(*) FROM adminMember WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			resultCnt = (int)rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		if (resultCnt != 0) {
			useYN = true;
		}
		
		
		return useYN;
		
	}
	
	public List<AdminDTO> adminLogin(String inputID, String inputPWD) {
		try {
			con = DBManager.getConnection();
			
			String sql = "SELECT * FROM adminMember WHERE id = ? AND pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputID);
			pstmt.setString(2, inputPWD);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				AdminDTO aDto = new AdminDTO(id, pwd, name, phone);
				
				adminInsert.add(aDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return adminInsert;
		
	}
	
	public List<AdminDTO> adminSelect(String inputID) {
		
		try {
			con = DBManager.getConnection();
			
			String sql = "SELECT * FROM adminMember WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputID);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				AdminDTO aDto = new AdminDTO(id, pwd, name, phone);
				
				adminInsert.add(aDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return adminInsert;
	}
	
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
