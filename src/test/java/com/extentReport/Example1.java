package com.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Example1 {
  
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
		
		//1. text in bold and itallic
		er.createTest("This is the testcase").log(Status.INFO, "<b><I>this is info message</I></b>");
		
		//2.add list data
		List<String> l1=new ArrayList<>();
		l1.add("sandy");
		l1.add("venky");
		l1.add("maneesh");
		
		er.createTest("Add List data").log(Status.INFO, MarkupHelper.createOrderedList(l1));
		
		//3. add json data  
		
		String json="{\n"
				+ "\"employee\":{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}\n"
				+ "}";
		er.createTest("Add json data").log(Status.INFO, MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
		
		
		//4.add xml data
		String xml="<note>\n"
				+ "<to>Tove</to>\n"
				+ "<from>Jani</from>\n"
				+ "<heading>Reminder</heading>\n"
				+ "<body>Don't forget me this weekend!</body>\n"
				+ "</note>";
		
		er.createTest("Add xml data").log(Status.INFO, MarkupHelper.createCodeBlock(xml, CodeLanguage.XML));
		
		//5.highlight the message
		er.createTest("Highlight msg").log(Status.INFO,MarkupHelper.createLabel("this is the highligted message", ExtentColor.RED));
		
		
		Desktop.getDesktop().browse(new File("report.html").toURI());
		er.flush();
		
		

	}

}
