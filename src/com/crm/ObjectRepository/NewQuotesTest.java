package com.crm.ObjectRepository;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.GenericLib.FileLib;
/**
 * 
 * @author yamini
 *
 */
public class NewQuotesTest extends BaseClass1  {
	
	@Test
	/**
	 * 
	 * creates NewQuotes with click on save
	 */
	public void CreateNewQuotesTest()throws Throwable
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
			
			
			CreatingNewQuotePage CNQ=PageFactory.initElements(driver,CreatingNewQuotePage.class );
	        CNQ.getSubjectnameEdit().sendKeys(FileLib.getExcelData("Sheet2", 1, 0));
	        
	        CNQ.getAssignedDropdown().click();
	             CNQ.getQuoteStageDropDown().click();
	           CNQ.getOrganizationLookUp().click();
	           
	           Set<String> set=driver.getWindowHandles();
	   		//get the window count
	   		Iterator<String> it=set.iterator();
	   		String parentwinSessionId=it.next();
	   		String childwinSessionId=it.next();
	   		//pass driver control to child window
	   		driver.switchTo().window(childwinSessionId);
	   	     CNQ.getSelectOrganizationLookUp().click();
	   	     Alert a1=driver.switchTo().alert();
	   	     a1.accept();
	   	  driver.switchTo().window(parentwinSessionId);
	   
	   		CNQ.getBillingAddressEdit().sendKeys(FileLib.getExcelData("Sheet2", 1, 1));
	      CNQ.getShippingAddressEdit().sendKeys(FileLib.getExcelData("Sheet2", 1, 2));
	     CNQ.getItemNameLookUp().click();
	     Set<String> set1=driver.getWindowHandles();
	   		//get the window count
	   		//capture session id from the set collection
	   		Iterator<String> it1=set1.iterator();
	   		String parentwinSessionId1=it1.next();
	   		String childwinSessionId1=it1.next();
	   		//pass driver control to child window
	   		driver.switchTo().window(childwinSessionId1);
	   	     CNQ.getSelectItemNameLookUp().click();
	   	  driver.switchTo().window(parentwinSessionId1);
	      CNQ.getQty1Edit().sendKeys(FileLib.getExcelData("Sheet2",1,3));
	
	  
      
	}
}