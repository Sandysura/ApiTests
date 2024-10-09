package com.Rahulshetty.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept {

	public static void main(String[] args)
	
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
	    System.out.println(driver.findElements(By.tagName("iframe")).size());
	    driver.switchTo().frame(0);
	    
	    Actions a=new Actions(driver);
	    WebElement source=driver.findElement(By.id("draggable"));
	    WebElement target=driver.findElement(By.id("droppable"));
	    
	    a.dragAndDrop(source, target).build().perform();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.linkText("Accept")).click();
	    
		
	}

}
