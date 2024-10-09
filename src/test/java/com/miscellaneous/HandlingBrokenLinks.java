package com.miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		
		WebDriverManager.chromedriver().setup();
		
	   
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement>links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:links)
		{
	       String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
	       System.out.println(url);
	      
	       HttpURLConnection con= (HttpURLConnection)new URL(url).openConnection();                con.setRequestMethod("HEAD");
	       con.connect();
	       int code=con.getResponseCode();
	       System.out.println(code);
	       if(code>400)
	       {
	    	   System.out.println("the link with "+link+"is failing with status code "+code);
	    	   a.assertTrue(false);
	       }
	       a.assertAll();
	       driver.close();
		}
	}

}
