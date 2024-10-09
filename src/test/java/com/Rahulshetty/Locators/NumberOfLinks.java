package com.Rahulshetty.Locators;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumberOfLinks {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement columnDriver=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonLinks=Keys.chord(Keys.COMMAND,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinks);
			Thread.sleep(5000);
			
			
		}

		Set<String>abc=driver.getWindowHandles();
		Iterator<String>it=abc.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		
		}
		

	}

}
