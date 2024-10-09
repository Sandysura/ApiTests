package com.ChromeDevProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools dt=driver.getDevTools();
		dt.createSession();
		//35 138
		
       // driver.executeCdpCommand("Emulation.setGeolocationOverride", k);
		dt.send(Emulation.setGeolocationOverride(java.util.Optional.of(35), java.util.Optional.of(138), java.util.Optional.of(1)));
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        
        driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
      //  String title= driver.findElement(By.xpath("//div[@class='default-ltr-cache-1dvfrvc e9eyrqp5']//h1")).getText();
       // System.out.println(title);
	}

}
