package com.Rahulshetty.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Locators2 {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		 String password=getString(driver);
		
		 driver.findElement(By.cssSelector("div button[class='go-to-login-btn']")).click();
		String name="sandeep";
		WebElement na=driver.findElement(By.cssSelector("form input[placeholder='Username']"));
		na.clear();
		na.sendKeys(name);
		driver.findElement(By.xpath("//input[contains(@name,'input')]")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElements(By.xpath("//div[@class='login-container']/h2")));
		Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "You are successfully logged in.");
	//	Assert.assertEquals(driver.findElements(By.cssSelector("div[class=login-container] h2")), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
    public  static String getString(WebDriver driver) throws InterruptedException
    {
    	driver.get("https://rahulshettyacademy.com/locatorspractice/");
    	driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys("sandeep");
    	driver.findElement(By.linkText("Forgot your password?")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.cssSelector("form input[placeholder='Name']")).sendKeys("sandeep");
    	driver.findElement(By.cssSelector("form input[placeholder='Email']")).sendKeys("sandy12@gmail.com");
    	driver.findElement(By.cssSelector("form input[placeholder='Phone Number']")).sendKeys("9876543212");
    	
    	driver.findElement(By.cssSelector("div button[class='reset-pwd-btn']")).click();
    	String pass=driver.findElement(By.cssSelector("form p")).getText();
    	String[]pass1=pass.split("'");
    	String[]pass2=pass1[1].split("'");
    	String p=pass2[0];
    	return p;
    }
}
