package com.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2 {
  
	 static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		//build engine object
		ExtentReports er=new ExtentReports();
		//build bhogie object
		ExtentSparkReporter esr=new ExtentSparkReporter("report.html");
		esr.config().setDocumentTitle("Test report ");
		esr.config().setReportName("Automation Testing");
		//attach both instances
		er.attachReporter(esr);
	    er.setSystemInfo("Tester", "Sandeep");
		
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions cr=new ChromeOptions();
	    cr.addArguments("--allow-remote-origins=*");
	    driver=new ChromeDriver(cr);
	    driver.get("https://www.google.com");
	    String path=Take();
	    String base=Take1();
	    
        er.createTest("Test1").log(Status.INFO, "This is for attaching ss").addScreenCaptureFromBase64String(base);
		
        er.createTest("Test2").log(Status.INFO, "This is for attaching ss").addScreenCaptureFromBase64String(base, "Google homepage");
        
        
        er.createTest("Test3").log(Status.INFO, "This is for attaching ss").addScreenCaptureFromPath(path);
        
        er.createTest("Test4").log(Status.INFO, "This is for attaching ss").addScreenCaptureFromPath(path, "Google Homepage");
        
        er.createTest("Test5").log(Status.FAIL, "this is the failed test").fail("this is failed",MediaEntityBuilder.createScreenCaptureFromBase64String(base,"homepage").build());
        
        er.createTest("Test5").log(Status.FAIL, "this is the failed test").fail("this is failed",MediaEntityBuilder.createScreenCaptureFromPath(path,"homepage").build());
        Desktop.getDesktop().browse(new File("report.html").toURI());
		er.flush();
		driver.quit();
		

	}
	
	public static String Take( ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File Desti=new File("./Screenshots/"+"pic.png");
		FileUtils.copyFile(Source, Desti);
		return Desti.getAbsolutePath();
	}
	
	public static String Take1( ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}

}
