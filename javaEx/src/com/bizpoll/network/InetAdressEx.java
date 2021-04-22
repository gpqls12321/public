package com.bizpoll.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAdressEx {

	Scanner scanner;

	public InetAdressEx() {
		System.out.print("Host 이름을 입력해 주세요 : ");
		scanner = new Scanner(System.in);

		/*
		 * 예외처리 반드시 해야될 때 : IO객체 쓸 때, 데이터베이스 객체 사용할 때 ***
		 * 
		 * 예외처리 세가지 try-catch / throw / throws
		 */

//		try {
//			InetAddress inetAddress = InetAddress.getByName(scanner.next());
//			System.out.println("이름 : " + inetAddress.getHostName());
//			System.out.println("Address : " + inetAddress.getHostAddress());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			InetAddress[] iaArr = InetAddress.getAllByName(scanner.next());
			System.out.println("이름 : " + iaArr[0].getHostName());
			for(InetAddress inetAddress2 : iaArr) {
				System.out.println("Address : " + inetAddress2.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
