package com.bizpoll.javaex;

public class Exercise3_07 {
	
	public static void main(String[] args) {
		
		// 변수 num의 값(임의의 수) 중에서 일의 자리를 1로 바꾸는 코드를 작성하시오.
		// 예) 변수 num의 값이 333이라면 331이 되고, 777이라면 771
		
		int num = 777;
		int result = num / 10 * 10 + 1;
		System.out.println(result);
	}

}
