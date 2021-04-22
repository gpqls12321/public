package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex08 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 나이를 입력하세요 : ");
		String age1 = sc.nextLine();
		int age = Integer.valueOf(age1);
		
		System.out.print("수정할 주소를 입력하세요 : ");
		String addr = sc.nextLine();
		
		System.out.print("수정할 사람의 번호를 입력하세요 : ");
		String num = sc.nextLine();
		int no = Integer.valueOf(num);
		
		sc.close();
		

		MemberDTO mDto = new MemberDTO(age, addr, no);
		int result = memUpdate(mDto);
		
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 성공");
		}
		
	}

	private static int memUpdate(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATE tblMember SET age = ?, addr = ? WHERE no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getAge());
			pstmt.setString(2, mDto.getAddr());
			pstmt.setInt(3, mDto.getNo());
			
			succ = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return succ;
	}

}
