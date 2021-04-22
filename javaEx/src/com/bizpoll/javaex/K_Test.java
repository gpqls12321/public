package com.bizpoll.javaex;

import java.util.Scanner;

public class K_Test {

	public static void main(String args[]) {

		/*
		 * 사용자가 임의의 수를 입력하면, 입력된 수가 각 자릿수의 합 
		 * 예) 임의의 수 12345를 입력할 경우 
		 * 출력 : 15(풀이 : 1 + 2 + 3 + 4 + 5)
		 */

		int sum = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 >> ");
		int num = scan.nextInt();

		/*
		 * 내가 회전 시킬 수 있는 횟수를 알면 for()
		 * 모르면 while()
		 */
		while (num > 0) { 
			sum += num % 10;
			num /= 10;
		}

		System.out.println("합 : " + sum);
		
		scan.close();
	}
}
