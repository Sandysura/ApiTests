package com.HandsOn;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandsOn6 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("checkBoxOption3")).click();
        String lable=driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[3]")).getText();
        WebElement se=driver.findElement(By.id("dropdown-class-example"));
        Select s=new Select(se);
        s.selectByVisibleText(lable);
        driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(lable);
        driver.findElement(By.id("alertbtn")).click();
         Alert alert=  driver.switchTo().alert();
        String text= alert.getText();
        System.out.println(text);
        
        if(text.contains(lable))
        {
        	Assert.assertTrue(true);
        }
        alert.accept();
	}

}
