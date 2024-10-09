package com.ChromeDevProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.fetch.Fetch;
import org.openqa.selenium.devtools.v126.network.model.Request;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException
	
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		DevTools dt=driver.getDevTools();
		dt.createSession();
		dt.send(Fetch.enable(Optional.empty(), Optional.empty()));
		dt.addListener(Fetch.requestPaused(), request->
		{
			Request req=request.getRequest();
			if(req.getUrl().contains("shetty"))
			{
				String mockedurl=req.getUrl().replace("=shetty", "=BadGuy");
				
				dt.send(Fetch.continueRequest(request.getRequestId(), java.util.Optional.of(mockedurl), 
						java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
					
			}
			else
			{
				dt.send(Fetch.continueRequest(request.getRequestId(), java.util.Optional.of(req.getUrl()), 
						java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
					
			}
		}
		);
		
	    	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
	        Thread.sleep(3000);
	        String avail= driver.findElement(By.cssSelector("p")).getText();
	        System.out.println(avail);
	        driver.close();
		

	}

}
