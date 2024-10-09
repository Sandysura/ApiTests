package com.Uploadfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	public static void main(String[] args) throws IOException 
	{
		String fruitname="Mango";
		String col="Season";
		String filepath="/Users/SA20465624/Downloads/download.xlsx";
		String Updateseason="Winter";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().window().maximize();

		//download
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		//edit excel
		File f=new File(filepath);
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		DataFormatter format=new DataFormatter();
		
		XSSFSheet sheet=wb.getSheet("Sheet1");
	    Iterator<Row> rows=sheet.rowIterator();
	  //to get fruitname row number
	    int l=1;
    	int frow=-1;
	    while(rows.hasNext())
	    {
	    	Row row =rows.next();
	    	
	    	Iterator<Cell> cee=row.cellIterator();
	    	while(cee.hasNext())
	    	{
	    		Cell val=cee.next();
	    		if(format.formatCellValue(val).equalsIgnoreCase(fruitname))
	    		{
	    			frow=l;
	    			System.out.println(l);
	    			System.out.println(format.formatCellValue(val));
	    		}
	    		
	    		
	    	}
	    	l++;
	    }
				
				
	   //to get column number of season
	    
	    XSSFSheet sheets=wb.getSheet("Sheet1");
	    Iterator<Row> rowsheet=sheets.rowIterator();
	    Row firstrow=rowsheet.next();
		Iterator<Cell> ce=firstrow.cellIterator();
		int k=1;
		int pcol=-1;
					
	    while(ce.hasNext())
		{
		  Cell value=ce.next();
			if(format.formatCellValue(value).equalsIgnoreCase(col))
				{
				   pcol=k;
				   System.out.println(k);
				   System.out.println(format.formatCellValue(value));
				}
			  k++;
						
		}
	    //update cell value
				
	    XSSFSheet sheet1=wb.getSheet("Sheet1");
	   Row rowfield= sheet1.getRow(frow-1);
	   Cell cellfield=rowfield.getCell(pcol-1);
	   cellfield.setCellValue(Updateseason);
	   FileOutputStream fos=new FileOutputStream(filepath);
	   wb.write(fos);
	   fis.close();
	   
	   
		//upload
		WebElement upload=driver.findElement(By.cssSelector("input[type='file'"));
		upload.sendKeys(filepath);
		
		//wait for msg to display
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		By toasttext=By.cssSelector(".Toastify__toast-body div:nth-child(2");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toasttext));
		String toastText=driver.findElement(toasttext).getText();
		System.out.println(toastText);
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toasttext));
		
		
		//get value of specfic row and column from table
		String pricecolumn=driver.findElement(By.xpath("//div[text()='"+col+"']")).getAttribute("data-column-id");
		String season=driver.findElement(By.xpath(" //div[text()='"+fruitname+"']/parent::div/parent::div/div[@id='cell-"+pricecolumn+"-undefined']")).getText();
		
		System.out.println(season);
		driver.close();
		
		
		
		
		
	}

}
