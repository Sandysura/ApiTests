package com.Oops.Polymorphism;

public class MethodOverriding extends ParentClass{
// in method overriding the method name and method signature are same
	public static void main(String[] args)
	{
		MethodOverriding m=new MethodOverriding();
		m.cost();
		m.colour();
	}
	public void cost()
	{
		System.out.println("the cost of bike is 2lakhs");
	}
	public void colour()
	{
		System.out.println("the colour is white");
	}

}
