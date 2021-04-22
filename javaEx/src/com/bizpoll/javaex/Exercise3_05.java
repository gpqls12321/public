package com.bizpoll.javaex;

public class Exercise3_05 {

	public static void main(String[] args) {

		/*
		 * 변수 num의 값(임의의 수)에 따라 '양수', '음수', '0' (num 값이 0일 경우)을 출력하는 코드를 작성하시오 
		 * (단, 삼항 연산자 이용)
		 */
		
		// 내가 한 것
		int num = 2154;
		String strnum = (num == 0) ? "0" : (num > 0) ? "양수" : "음수";
		System.out.println(num + " 는(은) " + strnum);
		
		
		int num1 = -1;
		System.out.println(num1 > 0 ? "양수" : (num1 < 0 ? "음수" : "양수"));
	}
	
}
	