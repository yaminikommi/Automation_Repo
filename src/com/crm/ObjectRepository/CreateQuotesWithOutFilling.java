package com.crm.ObjectRepository;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Quotes;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.GenericLib.FileLib;
import com.relevantcodes.extentreports.ExtentReports;

public class CreateQuotesWithOutFilling extends BaseClass1 
{
@Test
public void CreateQuotesWithOutFillingData()throws Throwable
{

HomePage hp=PageFactory.initElements(driver, HomePage.class);
Actions act=new Actions(driver);
/*performing the action on more drop down */
act.moveToElement(hp.getMoreDropDown()).perform();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	hp.getQuotes().click();
	System.out.println("clicked on quotes");
	Quotes1 q=PageFactory.initElements(driver, Quotes1.class);
	q.getCreateQuotes().click();
	System.out.println("clicked on  createdquotes");
    
    ClickingOnCreateQuotes cocq=PageFactory.initElements(driver,ClickingOnCreateQuotes.class);
	cocq.getClickOnSave().click();
	String actual=cocq.getAlertMsg();
	System.out.println(actual);
	cocq.getAlertAccept();
	String exp=FileLib.getExcelData("sheet3",0,0);
	Validation v=PageFactory.initElements(driver, Validation.class);
	String msg=v.Verifying(actual, exp);
	System.out.println(msg);

}
}