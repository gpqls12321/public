package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise3_08 {
	
	public static void main(String[] args) {
		
		/*
		 * 키보드로부터 입력받은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 
		 * 숫자일 때만 변수 result의 값이 true가 되도록 하는 코드 작성
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 입력 >> ");
		char ch = scan.next().charAt(0);
		scan.close();
		boolean result = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
		System.out.println(result);

	}

}
