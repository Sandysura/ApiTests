package com.Rahulshetty.Locators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators{
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		Actions ac=new Actions(driver);
	
		/*driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("sandy");
		driver.findElement(By.name("inputPassword")).sendKeys("122@");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("sandeep");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sandy@gmail.com");
		driver.findElement(By.cssSelector("form input:nth-child(4)")).sendKeys("987654321");
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys("sandeep");
		
		//driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
		
		*/
		
		
	
	}
}