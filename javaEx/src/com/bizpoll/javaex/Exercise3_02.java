package com.bizpoll.javaex;

public class Exercise3_02 {

	public static void main(String[] args) {
		int apple = 123; 
		int oneBasket = 10; 
		int basketQty = apple / oneBasket;

		int count = 0;
		if (apple / oneBasket > 0) {
			count++;
		}
		System.out.println(basketQty + count);
	}
}
