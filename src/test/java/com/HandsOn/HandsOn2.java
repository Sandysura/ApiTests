package com.HandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandsOn2 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("sandeep");
		driver.findElement(By.name("email")).sendKeys("sandysura23@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Sandy123@");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement ele=driver.findElement(By.id("exampleFormControlSelect1"));
		Select s=new Select(ele);
		s.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("23/02/2001");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.close();	

	}

}
