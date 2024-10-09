package com.Rahulshetty.Locators;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add2Cart {

	public static void main(String[] args) 
	{
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String [] items= {"Cucumber","Beetroot"};
		int k=0;
		List<WebElement> vegName=driver.findElements(By.cssSelector(".product-name"));
		
		List a=Arrays.asList(items);
		
		for(int i=0;i<vegName.size();i++)
		{
			String [] name=vegName.get(i).getText().split("-");
			String finalName=name[0].trim();
			
			
			if(a.contains(finalName))
               {
			    	k++;
				    driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				 
				    if(k==2)
				    {
				    	 break;
				    }
	
               }
		}
		
	}

}
