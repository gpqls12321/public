package com.bizpoll.javaex;

public class Exercise4_01_01 {

	public static void main(String[] args) {
		int sum = 0;
		int s = 0;
		int num = 0;
		
		//   초기화/ 조건식/증감식/블럭
		for(int i = 1; true; i++, s = -s) {
			num = s * i;
			sum += num;
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("num = " + num);
		System.out.println("sum = " + sum);
	}
}
