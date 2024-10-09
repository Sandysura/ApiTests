package com.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jdbc {

	public static void main(String[] args) throws SQLException
	{
		String host="localhost";
		String port="3306";
		String url="jdbc:mysql://"+host+":"+port+"/sandy";
		
		Connection con=DriverManager.getConnection(url, "root", "Sandy123@");
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from info where age=27");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		while(rs.next())
		{
			driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys(rs.getString("name"));
			driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys(rs.getString("gender"));
			
		}
		
		
		

	}

}
