package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;

public class MemberDAO {

	private MemberDAO() {
		// 외부에서 new 연산자 사용해서 생성 못하게 하는. (외부에서 접근 차단)
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberDTO getMember(String userId) {
		MemberDTO mDto = null;

		String sql = "SELECT * FROM member WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mDto = new MemberDTO();
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				mDto.setName(rs.getString("name"));
				mDto.setEmail(rs.getString("email"));
				mDto.setZipNum(rs.getString("zip_num"));
				mDto.setAddress(rs.getString("address"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setUseyn(rs.getString("useyn"));
				mDto.setIndate(rs.getDate("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mDto;
		
	}
	public int confirmID(String userId) {
		// 회원가입 유무 판별 변수
		int result = -1; // 0으로 해도 댐
		String sql = "SELECT * FROM member WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 데이터가 존재한다면
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
}