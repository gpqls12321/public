package com.bizpoll.javaex;

import java.util.Random;
import java.util.Scanner;

public class Exercise3_10 {

	public static void main(String[] args) {

		/*
		 * 요구사항 
		 * 1. 입력값을 문자열로 취득(메뉴선택시) 
		 * 		메뉴 : 1을 입력 시 게임시작 
		 * 			   2를 입력 시 게임 종료(System.exit(0)을 이용할 것) 
		 * 2. 종료하겠다는 의미의 숫자를 입력하지 않으면 선택 메뉴가 계속 표시 
		 * 3. 주사위 판정을 위한 사용자로부터 1~6사이의 값을 취득 (유효성 체크 그 외의 값이 취득되면 계속 반복해서 입력값 체크) 
		 * 4. 컴퓨터는 랜덤하게 숫자를 취득 (1~6까지)
		 */

		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();

		while (true) {
			System.out.println("\n");
			System.out.println("1 입력 시 게임 시작");
			System.out.println("2 입력 시 게임 종료");
			System.out.print("메뉴 선택 >> ");
			int selItem = scan.nextInt();

			if (String.valueOf(selItem).equals("2")) {
				System.out.println("Bye Bye");
				System.exit(0);
			} else if (String.valueOf(selItem).equals("1")) {
				System.out.println("Dice Game 시작");
				System.out.println("주사위를 굴려 볼까요?");
				System.out.print("1~6까지의 정수를 입력해 주세요 >> ");

				int userNum = scan.nextInt();

				while (true) {
					if (userNum < 1 || userNum > 6) {
						System.out.println("1~6까지의 정수를 입력해 주세요");
						userNum = scan.nextInt();
					} else {
						break;
					}
				}

				int comNum = rnd.nextInt(6) + 1;
				System.out.println("당신의 숫자는 " + userNum + " 입니다.");
				System.out.println("컴퓨터의 숫자는 " + comNum + " 입니다.");

				if (userNum > comNum) {
					System.out.println("You Win");
				} else if (userNum < comNum) {
					System.out.println("You Lose");
				} else {
					System.out.println("DRAW");
				}

				System.out.println("===============================================");
			}

		}

	}

}
