package com.miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCookies {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
	   
		WebDriver driver =new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("sessionkey");
		// this will delete specific cookie and to check the behaviour after deleteing the cookie
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

		

	}

}
