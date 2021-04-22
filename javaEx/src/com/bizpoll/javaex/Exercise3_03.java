package com.bizpoll.javaex;

import java.util.Scanner;

public class Exercise3_03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 >> ");
		int numOfApples = scan.nextInt();
		
		int sizeOfBucket = 10;
		
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket > 0 ? 1 : 0);
		
		System.out.println(numOfBucket);
	}
}
