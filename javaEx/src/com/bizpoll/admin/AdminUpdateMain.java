package com.bizpoll.admin;

import java.util.Scanner;

public class AdminUpdateMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();
		
		System.out.print("수정할 사람의 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		
		System.out.print("수정할 비밀번호를 입력하세요 : ");
		String pwd = sc.nextLine();
		
		System.out.print("수정할 전화번호를 입력하세요 : ");
		String phone = sc.nextLine();
		
		AdminDTO aDto = new AdminDTO(id, pwd, phone);
		int result2 = aDao.AdminUpdate(aDto);
		
		if(result2 > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}

}
