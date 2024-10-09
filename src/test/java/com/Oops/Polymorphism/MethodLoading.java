package com.Oops.Polymorphism;

public class MethodLoading {
//in method overloading the method name is same but the method signature is different 
	//the argument datatype and the numnber of argunents passing should be different
	public void get(String a)
	{
		System.out.println(a);
	}
	public void get(int a)
	{
		System.out.println(a);
	}
	public void get(int a,int b)
	{
		//System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args)
	{
		
		MethodLoading m=new MethodLoading();
		m.get(10);
		m.get("sandy");
		m.get(11, 12);
	}

}
