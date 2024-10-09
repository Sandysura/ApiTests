package com.Rahulshetty.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestDropdown {
	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		
		//count number of checkboxes
		List<WebElement> c=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(c.size());
		
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("aus");
		Thread.sleep(3000);
	    List<WebElement>options =driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
	    
	    
	    for(WebElement  s:options)
	    {
	    	
	    	System.out.println(s.getText());
	    }
	    	
	    
	    for(WebElement  s:options)
	    {
	    	if(s.getText().equalsIgnoreCase("austria"))
	    	{
	    		s.click();
	    		break;
	    	}
	    }
	    
		
	   // driver.close();
	}
	

}
