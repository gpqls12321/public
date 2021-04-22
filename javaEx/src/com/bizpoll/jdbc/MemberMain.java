package com.bizpoll.jdbc;

import java.util.List;
import java.util.Scanner;

public class MemberMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberSearch memSearch = new MemberSearch();
		
		System.out.print("검색하실 회원 번호를 입력해 주세요 : ");
		int searchKey = sc.nextInt();
		
		List<MemberDTO> memList = memSearch.memSearch(searchKey);
		
		if(memList.size() > 0) {
			for (MemberDTO memberDTO : memList) {
				System.out.println("검색하신 회원 정보는 아래와 같습니다");
				System.out.print(memberDTO.getNo() + " " + memberDTO.getName() + " " + memberDTO.getAge() + " " + memberDTO.getAddr() + " " + memberDTO.getPhone());
			}
		} else {
			System.out.println("회원이 존재하지 않습니다.");
		}
	}

}
