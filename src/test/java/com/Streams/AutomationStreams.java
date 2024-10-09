package com.Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationStreams {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement>ol=driver.findElements(By.xpath("//tr/td[1]"));
		List<Object>actual=ol.stream().map(s->s.getText()).collect(Collectors.toList());
		List<Object>expected=actual.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(actual.equals(expected));
	}

}
