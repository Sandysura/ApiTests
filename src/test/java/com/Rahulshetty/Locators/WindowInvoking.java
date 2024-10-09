package com.Rahulshetty.Locators;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowInvoking {

	public static void main(String[] args) throws IOException
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().minimize();
		
		
		driver.get("https://rahulshettyacademy.com/");

		 Set<String>handles=driver.getWindowHandles();
		Iterator<String>it= handles.iterator();
		String pId=it.next();
		String cId=it.next();
		driver.switchTo().window(cId);
		
		
		String course=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.close();
		driver.switchTo().window(pId);
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(course);
	   File file=	name.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file, new File("/Users/SA20465624/Documents/work/Locators/Screenshots"+"name"+".png"));
		
	   System.out.println(name.getRect().getDimension().getHeight());
	   System.out.println(name.getRect().getDimension().getWidth());
		

	}

}
