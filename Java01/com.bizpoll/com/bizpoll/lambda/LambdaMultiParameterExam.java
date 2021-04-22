package com.bizpoll.lambda;

public class LambdaMultiParameterExam {

	public static void main(String[] args) {
		
		Person3 person = new Person3();
		person.greeting(new Say3() {
			
			@Override
			public int something(int a, int b) {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you ><b");
				System.out.println("parameter value is : " + a + ", " + b);
				
				return 7;
			}
		});
		
		System.out.println("============================================");
		
		
		//java 1.8
		person.greeting((a, b) -> {
			System.out.println("This name is java.");	
			System.out.println("Thank you Lambda ><b");
			System.out.println("parameter value is : " + a + ", " + b);
			
			return 8;
		});
	}
}
