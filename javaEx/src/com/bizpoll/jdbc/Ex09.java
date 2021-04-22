package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원의 번호를 입력하세요 : ");
		int no = sc.nextInt();
		
		sc.close();
		
		MemberDTO mDto = new MemberDTO(no);
		int result = memDelete(mDto);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private static int memDelete(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "DELETE FROM tblMember WHERE no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getNo());
			
			succ = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return succ;
	}
}
