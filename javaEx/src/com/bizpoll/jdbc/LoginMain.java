package com.bizpoll.jdbc;

import java.util.List;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MemberLogin memLogin = new MemberLogin();

		System.out.print("로그인 할 회원 번호(아이디)를 입력해 주세요 : ");
		String searchKey1 = sc.nextLine();
		int searchKey = Integer.valueOf(searchKey1);
		
		System.out.print("비밀번호(이름)를 입력하세요 : ");
		String name = sc.nextLine();

		List<MemberDTO> memList = memLogin.memLogin(searchKey, name);

		if ( memList.size() > 0) {
			for (MemberDTO memberDTO : memList) {
				System.out.println(name + "님 안녕하세요");
			}
		} else {
			System.out.println("로그인 실패");
		}
	}

}
