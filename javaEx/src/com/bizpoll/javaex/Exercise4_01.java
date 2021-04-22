package com.bizpoll.javaex;

public class Exercise4_01 {

	public static void main(String[] args) {

		/*
		 * 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때 
		 * 몇까지 더해야 총합이 100이상이 되는지
		 */
		
		int num = 0;
		int sum = 0;

		while (sum < 100) {
			++num;
			if (num % 2 == 0) {
				sum = sum - num; // sum -= num;
			} else {
				sum += num;
			}
		}
		System.out.println(num);
		System.out.println("============================");
		
	
	}
}