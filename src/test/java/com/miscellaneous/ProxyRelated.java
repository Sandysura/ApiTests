package com.miscellaneous;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyRelated {

	public static void main(String[] args) 
	{
		EdgeOptions eo=new EdgeOptions();
		eo.setAcceptInsecureCerts(true);
		//whenever the website asks for certification acceptance to load page we can do by above method
		eo.addArguments("--headless");
		//to run code headless
		
		Proxy p=new Proxy();
		p.setHttpProxy("ipaddress:4444");
		eo.setCapability("proxy", p);
		// in order to set proxy to run a test we use above method
		
		eo.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//to blocking up window popups
		
		Map<String,Object>pref=new HashMap<String,Object>();
		pref.put("download.default_directory", "directory/path");
		eo.setExperimentalOption("prefs", pref);
		//to set path of downloading file
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(eo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

	}

}
