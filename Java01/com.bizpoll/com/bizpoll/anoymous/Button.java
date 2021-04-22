package com.bizpoll.anoymous;

public class Button {
	
	// 필드 타입으로 중첩 인터페이스 타입을 선언 
	OnClickListener listener;
	
	// 매개변수가 인터페이스 타입이 되면 다양한 구현 객체가 올 수 있다(매개 변수의 다형성)
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	// 중첩 인터페이스 사용은 바깥 클래스와 아주 밀접하고 
	// 외부에서는 사용하지 않고 내부에서만 사용할 때 쓰임
	interface OnClickListener {
		void onClick();
	}

}
