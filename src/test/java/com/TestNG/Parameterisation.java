package com.TestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterisation
{
 
	@Parameters({"url"})
	 @Test
	 public void test(String urlname)
	 {
		System.out.println(urlname);
		 
	 }
	 
	@Test(dataProvider="deal")
	public void readdata(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);
	}
	
	
	@DataProvider
	@Test
	public Object[][] deal()
	{
		Object[][] data=new Object[3][2];
		
		data[0][0]="Fname";
		data[0][1]="Fpassword";
		
		data[1][0]="Sname";
		data[1][1]="Spassword";
		
		data[02][0]="Tname";
		data[2][1]="Tpassword";
		
		return data;
		
	}
	 
	
}
