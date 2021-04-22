package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex10 {

	/*
	 * F5 : 
	 * F6 : 메서드 단위로 건너뜀
	 * F7 : 클래스 단위로 건너뜀
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 회원 번호를 입력하세요 : ");
		int no = sc.nextInt();
		
		sc.close();
		
		MemberDTO mDto = new MemberDTO(no);
		int result = memSelect(mDto);
		
		if(result > 0) {
			System.out.println("조회 성공");
		} else {
			System.out.println("조회 실패");
		}
	}

	private static int memSelect(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * FROM tblMember WHERE no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getNo());
			
			ResultSet succ = pstmt.executeQuery();
			
			while(succ.next()) {
				int no = succ.getInt("no");
				String name = succ.getString("name");
				int age = succ.getInt("age");
				String addr = succ.getString("addr");
				String phone = succ.getString("phone");
				
				System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
