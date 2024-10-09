package com.Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SerarchFilter {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement>original=driver.findElements(By.xpath("//tr/td[1]"));
		 
		List<WebElement>actual=original.stream().filter(x->x.getText().contains("Rice"))
		.collect(Collectors.toList());
		
		Assert.assertEquals(actual.size(), original.size());
		driver.close();
		
	}

}
