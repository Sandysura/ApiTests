package com.ChromeDevProtocol;
import java.net.URI;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopAuthenticate {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		Predicate<URI>uripredicate=uri-> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uripredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("https:httpbin.org/basic-auth/foo/bar");

	}

}
