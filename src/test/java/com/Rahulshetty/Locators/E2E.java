package com.Rahulshetty.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E {

	
	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		 driver.findElement(By.xpath("//div[@id='dropdownGroup1'] //a[@value='BLR']")).click();
		
		
		 driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//div[@id='dropdownGroup1'] //a[@value='MAA'])[2]")).click();
		
		//driver.findElement(By.xpath(" //input[@id='ctl00_mainContent_view_date1']")).click();
		driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("it is enabled");
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		int n=1;
		while(n<3)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			n++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		WebElement e=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s=new Select(e);
		s.selectByVisibleText("INR");
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		

}
}
