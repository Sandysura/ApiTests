package com.ChromeDevProtocol;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.fetch.Fetch;
import org.openqa.selenium.devtools.v126.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v126.network.model.ErrorReason;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkFailRequest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools dt=driver.getDevTools();
		dt.createSession();
		Optional<List<RequestPattern>>patterns=Optional.of(Arrays.asList(new RequestPattern
				(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		
		
		dt.send(Fetch.enable(patterns,Optional.empty()));
		
		dt.addListener(Fetch.requestPaused(), request->
		{
			dt.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
	}

}
