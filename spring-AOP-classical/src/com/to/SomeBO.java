package com.to;

public class SomeBO {

	public void validate() {
		System.out.println("validation stuff from BusinessObject");
	}
	
	public void validate(int age) throws Exception{
		if(age<18) {
			throw new ArithmeticException("Not valid age");
		}else {
			System.out.println("Vote confirmed");
		}
	}
}
