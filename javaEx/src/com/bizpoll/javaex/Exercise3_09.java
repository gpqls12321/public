package com.bizpoll.javaex;

public class Exercise3_09 {

	public static void main(String[] args) {
		/*
		 * 대문자를 소문자로 변경하는 코드 작성 단, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경 힌트 : 문자코드는 소문자가
		 * 대문자보다 32만큼 더 큼 예) 변수 ch에 'A'라는 대문자를 입력 받았을 때 'a'로 출력
		 */

		char ch = 'D' + 32;
		System.out.println(ch);

		char ch1 = 'F';
		char lowerCase = ('A' <= ch1 && ch1 <= 'Z') ? (char) (ch1 + 32) : ch1;
		System.out.println("ch1 to lowerCase : " + lowerCase);

		System.out.println("======================================================");
		/*
		 * 1부터 100까지의 수 중에서 3의 배수와 그 개수를 출력하시오
		 */
		int count = 0 ;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println("3의 배수 개수 : " + count);
	}
}
