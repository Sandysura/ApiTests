package com.Rahulshetty.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClas {

	
	 
	public static void main(String[] args)throws InterruptedException
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		Actions a=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
		WebElement ele1=driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(ele).contextClick().build().perform();
		a.moveToElement(ele1).click().keyDown(Keys.SHIFT).sendKeys("dell").doubleClick().build().perform();
		
		
		
	}

}
