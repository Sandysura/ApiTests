package com.Rahulshetty.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headLessBrowser {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
	    op.addArguments("--headless");
	    op.addArguments("--disable-notifications");//to handle cookies
		WebDriver driver =new ChromeDriver(op);
		driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
	}

}
