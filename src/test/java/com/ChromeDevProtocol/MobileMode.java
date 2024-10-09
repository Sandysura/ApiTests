package com.ChromeDevProtocol;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileMode {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools dt=driver.getDevTools();
		dt.createSession();
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("width",600);
		m.put("height",1000);
		m.put("deviceScaleFactor",50);
		m.put("mobile",true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",m );
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		
	}

}
