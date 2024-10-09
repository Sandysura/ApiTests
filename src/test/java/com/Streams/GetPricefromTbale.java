package com.Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetPricefromTbale {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement>ol=driver.findElements(By.xpath("//tr/td[1]"));
        
		List<String>price=ol.stream().filter(s->s.getText().contains("Beans")).map(s->getvegprice(s))
		.collect(Collectors.toList());
		price.stream().forEach(s->System.out.println(s));
		driver.close();
	}

	private static String getvegprice(WebElement s)
	{
		String p=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return p;
	}
  
}
