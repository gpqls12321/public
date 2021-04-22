package com.bizpoll.javaex;

public class Exercise4_03 {

	public static void main(String[] args) {
		
		/*
		 * 1과 1부터 시작하는 피보나치 수열의 10번째 수는 무엇인지
		 * 1,1,2,3,5,8,13,21,34,55
		 */
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1 + "," + num2 + ",");
		
		for(int i = 0; i < 4; i++) {
			num3 = num1 + num2; 
			num1 = num3; 
			num2 = num3 + num2;
			System.out.print(num3 + "," + num2 + ",");
		}
		
	}
}
