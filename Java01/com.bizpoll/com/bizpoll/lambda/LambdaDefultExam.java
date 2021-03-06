package com.bizpoll.lambda;

public class LambdaDefultExam {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.greeting(new Say() {
			
			@Override
			public void something() {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you ><b");
			}
		});
		
		System.out.println("============================================");
		
		
		//java 1.8
		// (매개변수) -> {처리 내용}
		person.greeting(() -> {
			System.out.println("My name is java.");	
			System.out.println("Nice to meet you ><b");
		});
	}
}
