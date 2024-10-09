package com.Oops.encapsulation;

public class A {
	
	private  int value;

	public int getValue() {
		return --value;
	}

	public void setValue(int value) {
		this.value = value;
		System.out.println(value);
	}
	

}
