package com.bizpoll.admin;

import java.util.List;
import java.util.Scanner;

public class AdminMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();
		
		String id = null;
		while(true) {
			System.out.print("아이디를 입력하세요 : ");
			id = sc.nextLine();
			
			boolean bYes = aDao.adminIdCheck(id);
			if(bYes == true) {
				System.out.println("중복된 아이디 입니다");
			} else {
				System.out.println("사용 가능한 아이디 입니다");
				break;
			}
		}
		
		System.out.print("비밀번호를 입력하세요 : ");
		String pwd = sc.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("전화번호를 입력하세요 : ");
		String phone = sc.nextLine();
		
		int admin = aDao.memInsert(id, pwd, name, phone);
		
		if(admin > 0) {
				System.out.println("등록 성공");
			
		} else {
			System.out.println("등록 실패");
		}
		
		
		System.out.print("아이디를 입력하세요 : ");
		id = sc.nextLine();
		
		System.out.print("비밀번호를 입력하세요 : ");
		pwd = sc.nextLine();
		
		List<AdminDTO> adminList = aDao.adminLogin(id, pwd);
		
		if(adminList.size() > 0) {
			System.out.println(name + "님 안녕하세요");
		} else {
			System.out.println("로그인 실패");
		}
		
		System.out.print("조회할 관리자 아이디를 입력하세요 : ");
		id = sc.nextLine();
		adminList = aDao.adminSelect(id);
		
		System.out.println("아이디 : " + adminList.get(admin).getId());
		System.out.println("이름 : " + adminList.get(admin).getName());
		System.out.println("전화번호 : " + adminList.get(admin).getPhone());
		
		
		
		System.out.print("수정할 사람의 아이디를 입력하세요 : ");
		id = sc.nextLine();
		
		System.out.print("수정할 비밀번호를 입력하세요 : ");
		pwd = sc.nextLine();
		
		System.out.print("수정할 전화번호를 입력하세요 : ");
		phone = sc.nextLine();
		
		AdminDTO aDto = new AdminDTO(id, pwd, phone);
		int result2 = aDao.AdminUpdate(aDto);
		
		if(result2 > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
}
