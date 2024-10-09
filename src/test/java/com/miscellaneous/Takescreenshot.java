package com.miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Takescreenshot {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
	   
		WebDriver driver =new ChromeDriver(op);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		op.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		TakesScreenshot sc=(TakesScreenshot)driver;
		File f=sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("/Users/SA20465624/Documents/work/RahulShettyBasics/Screenshots/sc1.png"));
		//System.out.println(driver.getTitle());
         driver.close();
	}

}
