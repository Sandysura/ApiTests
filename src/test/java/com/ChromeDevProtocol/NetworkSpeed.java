package com.ChromeDevProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args)
	
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		DevTools dt= driver.getDevTools();
		dt.createSession();
		dt.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		
		dt.send(Network.emulateNetworkConditions(true,  3000, 20000, 10000, Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
		dt.addListener(Network.loadingFailed(), loadfail->
		{
			System.out.println(loadfail.getErrorText());
			System.out.println(loadfail.getBlockedReason());
			
		}
		);
		long start=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		long end=System.currentTimeMillis();
		System.out.println(end-start);//17324
		
	}

}
