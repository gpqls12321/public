package com.bizpoll.lambda;

public class LambdaReturnExam {

	public static void main(String[] args) {
		
		Person1 person = new Person1();
		person.greeting(new Say1() {
			
			@Override
			public int something() {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you ><b");
				
				return 7;
			}
		});
		
		System.out.println("============================================");
		
		
		//java 1.8
		person.greeting(() -> {
			System.out.println("This name is java.");	
			System.out.println("Thank you Lambda ><b");
			
			return 8;
		});
	}
}
