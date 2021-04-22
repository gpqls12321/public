package com.bizpoll.anoymous;

public class AnoymousMain {
	
	public static void main(String[] args) {
		
		Anoymous anoymous = new Anoymous();
		
		anoymous.field.wake();
		
		anoymous.method1();
		
		anoymous.method2(new Person() {
			String studentNo;
			
			void study() {
				System.out.println("공부합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});
		
	}

}
