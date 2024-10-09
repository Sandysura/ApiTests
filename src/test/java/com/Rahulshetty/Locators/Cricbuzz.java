package com.Rahulshetty.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricbuzz {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.cricbuzz.com/live-cricket-scores/92993/das-vs-jks-4th-match-lanka-premier-league-2024");
		driver.manage().window().maximize();
		
		String striker=driver.findElement(By.xpath("(//div[@class='cb-col cb-col-50']//child::a[@class='cb-text-link ng-binding'])[1]")).getText();
		String bowler=driver.findElement(By.xpath("(//div[@class='cb-col cb-col-50']//child::a[@class='cb-text-link ng-binding'])[3]")).getText();
        System.out.println(striker);
        System.out.println(bowler);
        driver.close();
	}

}
