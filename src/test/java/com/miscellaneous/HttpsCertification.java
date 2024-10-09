package com.miscellaneous;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpsCertification {

	public static void main(String[] args)
	{
		
		EdgeOptions eo=new EdgeOptions();
		eo.setAcceptInsecureCerts(true);
		eo.addArguments("--headless");
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(eo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
	}

}
