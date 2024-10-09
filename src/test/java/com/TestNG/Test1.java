package com.TestNG;

import org.testng.annotations.Test;


public class Test1 {
	
	@Test(enabled=true)
	public void t1()
	{
		System.out.println("t1  method");
		
	}
	
	@Test(dependsOnMethods= {"t1"})
	public void t2()
	{
		System.out.println("t2  method");
		
	}
	
	@Test(dependsOnMethods= {"t2"})
	public void t3()
	{
		System.out.println("t3  method");
		
	}
	
	@Test(groups={"sanity"})
	public void t4()
	{
		System.out.println("t4  method");
		
	}
	
	@Test
	public void t5()
	{
		System.out.println("t5 method");
	}

}