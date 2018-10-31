package com.crm.GenericLib;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
/**
 * 
 * @author yamini
 *
 */

public class BaseClass {
	public static WebDriver driver;
	FileLib file=new FileLib();
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		String currentData=new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(currentData);
		//Generate Advance Report
		report=new ExtentReports("./advanceReport/"+currentData+"_extent.html");
		
		//Load and use setting of the extent report
		report.loadConfig(new File("./extent-config.xml"));
		}
	@AfterSuite
	public void configAs()
	{
		report.flush();
		report.close();
	}
	@BeforeClass
	public void configBC()
	{
		driver=new FirefoxDriver();
	}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		System.out.println("login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Properties pobj=file.getPropertiesObj();
		driver.get(pobj.getProperty("url"));
		//driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		}
	@AfterMethod
	public void configAM()
	{
		WebElement  wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}	
		
		@AfterClass
	public void configAC()
	{
	driver.close();	
	}

}











