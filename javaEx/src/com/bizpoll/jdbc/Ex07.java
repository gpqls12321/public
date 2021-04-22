package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호를 입력하세요 : ");
		String num = sc.nextLine();
		int no = Integer.valueOf(num);
		
		System.out.print("회원 이름을 입력하세요 : ");
		String name =sc.nextLine();
		
		System.out.print("회원 나이를 입력하세요 : ");
		String age1 = sc.nextLine();
		int age = Integer.valueOf(age1);
		
		System.out.print("주소를 입력하세요 : ");
		String addr = sc.nextLine();
		
		System.out.print("전화번호를 입력하세요 : ");
		String phone = sc.nextLine();
		
		sc.close();
		
		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);
		
		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
		int result = memInsert(mDto);
		
		if(result > 0) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		
	}

	private static int memInsert(MemberDTO mDto) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pw = "1234";
		
		int succ = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 

			Connection con = DriverManager.getConnection(url, user, pw);

			String sql = "INSERT INTO tblMember VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());
			
			succ = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return succ;
	}
}
