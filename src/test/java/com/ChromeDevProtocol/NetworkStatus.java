package com.ChromeDevProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Request;
import org.openqa.selenium.devtools.v126.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkStatus {

	public static void main(String[] args) 
	{
       WebDriverManager.chromedriver().setup();
       ChromeDriver driver=new ChromeDriver();
       
       DevTools devtools=driver.getDevTools();
       devtools.createSession();
       
       
       //driver.executeCdpCommand("Network.enable", m);
		devtools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
       
       devtools.addListener(Network.requestWillBeSent(), request ->
       {
    	   Request req=request.getRequest();
    	  // System.out.println(req.getUrl());
       });
       
       devtools.addListener(Network.responseReceived(), response ->
       {
    	   Response res=response.getResponse();
    	   //System.out.println(res.getUrl());
    	   if(res.getStatus().toString().startsWith("4"))
    	   {
    		   System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
    	   }
    	  
       });
       
       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
       driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
       driver.close();
       

	}

}
