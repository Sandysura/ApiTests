package com.Rahulshetty.Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		String Omonth="2";
		String Oday="23";
		String Oyear="2021";
		String[] actual= {Omonth,Oday,Oyear};
		
		
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		
		driver.findElement(By.xpath("//button[text()='"+Oyear+"']")).click();
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(Omonth)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+Oday+"']")).click();
		
		List<WebElement>expected =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<expected.size();i++)
		{
			System.out.println(expected.get(i).getAttribute("value"));
			Assert.assertEquals(expected.get(i).getAttribute("value"),actual[i] );
		}
		
		driver.close();
	}

}
