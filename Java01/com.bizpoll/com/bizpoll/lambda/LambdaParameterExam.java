package com.bizpoll.lambda;

public class LambdaParameterExam {

	public static void main(String[] args) {
		
		Person2 person = new Person2();
		person.greeting(new Say2() {
			
			@Override
			public int something(int a) {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you ><b");
				System.out.println("parameter value is : " + a);
				
				return 7;
			}
		});
		
		System.out.println("============================================");
		
		
		//java 1.8
		person.greeting(a -> {
//		person.greeting((a) -> {});
			System.out.println("This name is java.");	
			System.out.println("Thank you Lambda ><b");
			System.out.println("parameter value is : " + a);
			
			return 8;
		});
	}
}
