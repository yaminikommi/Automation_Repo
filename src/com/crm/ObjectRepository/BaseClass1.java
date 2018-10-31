package com.crm.ObjectRepository;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.GenericLib.FileLib;
import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass1 {
	public static WebDriver driver;
	//FileLib f=new FileLib();
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("beforesuite");
		String currentData=new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(currentData);
		//Generate Advance Report
		report=new ExtentReports("./advanceReport/"+currentData+"_extent.html");
		
		//Load and use setting of the extent report
		report.loadConfig(new File("./extent-config.xml"));
		System.out.println("ending before suite");
		}
	@AfterSuite
	public void configAs()
	{
		report.flush();
		report.close();
	}
	

	@org.testng.annotations.BeforeClass
	public void configBC()throws Throwable
	{
		System.out.println("beforeclass");
	Properties pObj=FileLib.getPropertiesObj();
	String bName=pObj.getProperty("browser");
	if(bName.equals("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver", "./resourses/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(bName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./resourses/chromedriver.exe");
		driver=new ChromeDriver();
	}
	System.out.println("ending before class");
	}
	
	@BeforeMethod
	public void configBM()throws Throwable
	{
		Properties pObj=FileLib.getPropertiesObj();

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get(pObj.getProperty("url"));
		driver.get("http://localhost:8888");
		Login lp=PageFactory.initElements(driver, Login.class);
		lp.loginToApp();
		}
	@AfterMethod
	public void configAM()
	{
		
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		act.moveToElement(hp.getGoToAdmin()).perform();
		   hp.getSignoutbtn().click();
		   
	}
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
	
	}