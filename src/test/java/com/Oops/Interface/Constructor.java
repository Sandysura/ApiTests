package com.Oops.Interface;

public class Constructor {

	//will not return anything 
	//name of class and method should be same
	//default constructor
	//whenever an object is created automatically constrcutor is called
	public Constructor()
	{
		System.out.println("i am in constructor method");
	}
	public Constructor(int a,int b)
	{
		System.out.println("i am in parameterised constructor method");
	}
	public void get()
	{
		System.out.println("i am in get method");
	}
	public static void main(String[] args)
	{
		Constructor c=new Constructor();
		Constructor cd=new Constructor(4,5);

	}

}
