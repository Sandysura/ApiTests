package com.Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		
		List<String>price;
        do 
        {
          List<WebElement>lis=driver.findElements(By.xpath("//tr/td[1]"));
		  price=lis.stream().filter(s->s.getText().contains("Guava")).map(s->getvegprice(s))
		  .collect(Collectors.toList());
		  price.stream().forEach(s->System.out.println(s));
		
		   if(price.size()<1)
		   {
		    	driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		   }
		   
        }while(price.size()<1);
		driver.close();
	}

	private static String getvegprice(WebElement s)
	{
		String p=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return p;
	}

	}


