package com.bizpoll.javaex;

public class Exercise3_04 {

	public static void main(String args[]) {

		/*
		 *  변수 num 의 값(임의의 수) 중에서 백의 자리 이하를 버리는 코드를 작성하시오.
		 *  예) 변수 num의 값이 456이라면 400이 되고, 111이라면 100이 됨.
		 */
		
		
		// 내가 한 것
		int num = 956;
		int result = (num / 100) * 100;
		System.out.println(result);
		
		
		int num1 = 123456;
		System.out.println(num1 / 100 * 100);

	}

}
