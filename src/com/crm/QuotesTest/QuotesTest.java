package com.crm.QuotesTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.FileLib;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
/**
 * 
 * @author Yamini
 *
 */
public class QuotesTest extends BaseClass
{

//creates Quotes and click on save
	@Test(groups={"SmokeTest"})
	/**
	 * creates New Quotes with all mandatory fields and save the New Quotes
	 */
		public void createQuotes() throws Throwable
	{
		
	ExtentTest test= report.startTest("createQuotes");
	//identifying more drop down	
	WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act=new Actions(driver);
		//performing the action on more drop down
		act.moveToElement(wb).perform();
	
		test.log(LogStatus.INFO, "clicking on more drop down");
		/*identifying and doing action on quotes module under more drop down*/
		driver.findElement(By.name("Quotes")).click();
		//click on create Quotes
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		test.log(LogStatus.INFO, "clicking on create  Quotes");

		/*passing subject data in subject text field*/
		driver.findElement(By.name("subject")).sendKeys("mobile");
		test.log(LogStatus.INFO, "passing subject data in subject test field");

		driver.findElement(By.name("assigned_user_id")).click();
		driver.findElement(By.name("quotestage")).sendKeys("created");
	/*click on look up icon of organization name */
		driver.findElement(By.xpath("//*[@id='single_accountid']/following-sibling::img ")).click();
		test.log(LogStatus.INFO, "clicking on lookup icon of organization name");

		//capture session id
		Set<String>set=driver.getWindowHandles();
		test.log(LogStatus.INFO,"handling multiple windows");
		//get the window count
		System.out.println(set.size());
		//capture session id from the set collection
		Iterator<String> it=set.iterator();
		String parentwinSessionId=it.next();
		String childwinSessionId=it.next();
		//pass driver control to child window
		driver.switchTo().window(childwinSessionId);
		test.log(LogStatus.INFO, "navigating to child window");
		//click "abc" in child window
		driver.findElement(By.linkText("abc")).click();
		test.log(LogStatus.INFO, "click on abc organization name from child window");
		
		//close child window
	//driver.close();
		
		driver.switchTo().alert().accept();
		driver.switchTo().window(parentwinSessionId);
		test.log(LogStatus.INFO, "navigating back to parent window");

		/*click on look up icon of item name */
	 driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
		test.log(LogStatus.INFO, "clicking on lookup icon of item name");

	 Set<String>set1=driver.getWindowHandles();
	 test.log(LogStatus.INFO,"handling multiple windows");
		//get the window count
		System.out.println(set1.size());
		//capture session id from the set collection
		Iterator<String> it1=set1.iterator();
		String parentwinSessionId1=it1.next();
	String childwinSessionId1=it1.next();
		//pass driver control to child window
		driver.switchTo().window(childwinSessionId1);
		test.log(LogStatus.INFO, "navigating to child window");
		
		driver.findElement(By.xpath("//a[text()='samsung']")).click();
		test.log(LogStatus.INFO, "click on samsung item name from child window");
		//pass driver control to parent window
		driver.switchTo().window(parentwinSessionId1);
		test.log(LogStatus.INFO, "navigating back to parent window");
		
		
		driver.findElement(By.name("bill_street")).sendKeys("whitefield");
		test.log(LogStatus.INFO, "passing data into billing address field");

		driver.findElement(By.name("ship_street" )).sendKeys("silkboard");
		test.log(LogStatus.INFO, "passing data into shipping address field");

		
		//driver.close();
		driver.findElement(By.id("qty1")).sendKeys("30");
		test.log(LogStatus.INFO, "passing data into quantity field");

		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		test.log(LogStatus.INFO, "clicking on save button");

		/*getting confirmation text present after save*/
		String configMsg=driver.findElement(By.xpath("//span[contains(text(),'mobile -  Quote Information')]")).getText();

		test.log(LogStatus.INFO, "getting confirmation text present after save");
		
		/*getting expected message from excel sheet*/
		/*String expmsg=FileLib.getExcelData("sheet1", 1, 4);
		System.out.println(expmsg);
		test.log(LogStatus.INFO, expmsg);
		//Assert.assertEquals(configMsg, expmsg);
		org.testng.Assert.assertEquals(configMsg, expmsg);*/
          report.endTest(test);

		}
	
	
	
	//creates Quotes and click on cancel
	 @Test
	public void createQuotesTest()
	{
		 ExtentTest test= report.startTest("createQuotesTest");
		//identifying more drop down
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act=new Actions(driver);
		/*performing action on more drop down*/
          act.moveToElement(wb).perform();
  		test.log(LogStatus.INFO, "clicking on more drop down");
		/*identifying  and doing action on Quotes module under more drop down*/
       driver.findElement(By.name("Quotes")).click();
		
		/*clicking on create Quotes*/

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		test.log(LogStatus.INFO, "clicking on create Quotes");
		/*passing subject data in subject test field*/
        driver.findElement(By.name("subject")).sendKeys("mobile");
		test.log(LogStatus.INFO, "passing subject data in subject test field");

		driver.findElement(By.name("assigned_user_id")).click();
		test.log(LogStatus.INFO, "passing assigened user");
		driver.findElement(By.name("quotestage")).sendKeys("created");
		test.log(LogStatus.INFO,"passing Quotes stage in created");
	    /* click on lookup icon of organization name */
		driver.findElement(By.xpath("//*[@id='single_accountid']/following-sibling::img ")).click();
		test.log(LogStatus.INFO, "clicking on lookup icon of Organization name");

		//capture session id
		/*writing code for handling multiple windows for organization name*/

		Set<String>set=driver.getWindowHandles();
		test.log(LogStatus.INFO,"handling multiple windows");
          //get the window count
		System.out.println(set.size());
		//capture session id from the set collection
		Iterator<String> it=set.iterator();
		String parentwinSessionId=it.next();
		String childwinSessionId=it.next();
		/*pass driver control to child window*/
		driver.switchTo().window(childwinSessionId);
		test.log(LogStatus.INFO, "navigating to child window");

		//click "abc" in child window
		/*click on abc  organization name from child window*/
          driver.findElement(By.linkText("abc")).click();
  	test.log(LogStatus.INFO, "click on abc organization name from child window");
            //close child window
		  //driver.close();
	  driver.switchTo().alert().accept();
		/*navigating back to parent window*/
	   driver.switchTo().window(parentwinSessionId);
		test.log(LogStatus.INFO, "navigating back to parent window");
		
		
    /*click on look up icon of item name */
    driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
	test.log(LogStatus.INFO, "clicking on lookup icon of Item name");
	 Set<String>set1=driver.getWindowHandles();
	 test.log(LogStatus.INFO,"handling multiple windows");
		//get the window count
		System.out.println(set1.size());
		//capture session id from the set collection
		Iterator<String> it1=set1.iterator();
		String parentwinSessionId1=it1.next();
		String childwinSessionId1=it1.next();
		//pass driver control to child window
		driver.switchTo().window(childwinSessionId1);
		test.log(LogStatus.INFO, "navigating to child window");
		/*click on abc  organization name from child window*/
		driver.findElement(By.xpath("//a[text()='samsung']")).click();
		test.log(LogStatus.INFO, "click on samsung item name from child window");
		driver.switchTo().window(parentwinSessionId1);
		test.log(LogStatus.INFO, "navigating back to parent window");
		
		
		driver.findElement(By.name("bill_street")).sendKeys("whitefield");
	   test.log(LogStatus.INFO, "passing data into billing address field");

		driver.findElement(By.name("ship_street" )).sendKeys("silkboard");
		test.log(LogStatus.INFO, "passing data into shipping address field");

		
		//driver.close();
		/*passing data into quantity field*/

		driver.findElement(By.id("qty1")).sendKeys("30");
		test.log(LogStatus.INFO, "passing data into quantity field");
         driver.findElement(By.xpath("//input[@title='Cancel [Alt+X]']")).click();
 		test.log(LogStatus.INFO, "clicking on cancel button");
 		
 		/*getting confirmation text present after save*/
 		String configMsg=driver.findElement(By.xpath("//a[(text()='Quotes')]")).getText();
		

		test.log(LogStatus.INFO, "getting confirmation text present after cancel");
	       report.endTest(test);

          }
         
		
	
	
		//open creates quotes with out filling any field click on save
		@Test
		public void createQuoteswithoutFillingTest() throws Throwable	
		{
			ExtentTest test=report.startTest("createQuoteswithoutFillingTest");
			/*Identifying more drop down*/
      WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			Actions act=new Actions(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*performing action on more drop down*/
	         act.moveToElement(wb).perform();
	        test.log(LogStatus.INFO, "clicking on more drop down");
			/*identifying  and doing action on Quotes module under more drop down*/
              driver.findElement(By.name("Quotes")).click();
      		test.log(LogStatus.INFO, "identifying  and doing action on Quotes module under more drop down");
      		/*clicking on create purchase Order*/
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			test.log(LogStatus.INFO, "clicking on create Quotes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*without filling anyfield click on save*/
			driver.findElement(By.name("button")).click();
			test.log(LogStatus.INFO, "without create any field click on save");
			/*alert pop up window open*/
			Alert a1=driver.switchTo().alert();
			test.log(LogStatus.INFO, "alert pop up msg should be displayed");
			a1.accept();
			test.log(LogStatus.INFO, "alert pop up should be accept");
			/*getting confirmation text present */

			String configMsg=driver.findElement(By.xpath("//span['Creating New Quote']")).getText();
			test.log(LogStatus.INFO, "getting confirmation text present ");
		       report.endTest(test);
		} 
		
		
		
	//creates Quotes click on Edit
		@Test(groups={"SmokeTest"})
		public void createQuotesTest1()
		{
			ExtentTest test=report.startTest("createQuotesTest1");
			/*Identifying more drop down*/
 WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			Actions act=new Actions(driver);
			/*performing action on more drop down*/
			test.log(LogStatus.INFO, "clicking on more drop down");
              act.moveToElement(wb).perform();
      		/*identifying  and doing action on purchase order module under more drop down*/
            driver.findElement(By.name("Quotes")).click();
    		test.log(LogStatus.INFO, "identifying  and doing action on Quotes module under more drop down");
    		/*clicking on create Quotes */
       driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		test.log(LogStatus.INFO, "clicking on create Quotes");
		/*passing subject data in subject test field*/
       driver.findElement(By.name("subject")).sendKeys("laptop");
		test.log(LogStatus.INFO, "passing subject data in subject test field");
		driver.findElement(By.name("assigned_user_id")).click();
		driver.findElement(By.name("quotestage")).sendKeys("created");
		
		/*clicking on lookup icon of organization name */
   driver.findElement(By.xpath("//*[@id='single_accountid']/following-sibling::img ")).click();
      test.log(LogStatus.INFO, "clicking on lookup icon of organization  name");

			//capture session id
			Set<String>set=driver.getWindowHandles();
			test.log(LogStatus.INFO,"handling multiple windows");
              //get the window count
			System.out.println(set.size());
			//capture session id from the set collection
			Iterator<String> it=set.iterator();
			String parentwinSessionId=it.next();
			String childwinSessionId=it.next();
			//pass driver control to child window
			driver.switchTo().window(childwinSessionId);
			test.log(LogStatus.INFO, "navigating to child window");
           //click "abc" in child window
			driver.findElement(By.linkText("abc")).click();
			test.log(LogStatus.INFO, "click on abc organization name from child window");
			//close child window
			//driver.close();
			
			driver.switchTo().alert().accept();
			driver.switchTo().window(parentwinSessionId);
			test.log(LogStatus.INFO, "navigating back to parent window");
	
			/*clicking on lookup icon of organization name */
		 driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
		 test.log(LogStatus.INFO, "clicking on lookup icon of item  name");
		 Set<String>set1=driver.getWindowHandles();
			test.log(LogStatus.INFO,"handling multiple windows");

			//get the window count
			System.out.println(set1.size());
			//capture session id from the set collection
			Iterator<String> it1=set1.iterator();
			String parentwinSessionId1=it1.next();
			String childwinSessionId1=it1.next();
			//pass driver control to child window
			driver.switchTo().window(childwinSessionId1);
			test.log(LogStatus.INFO, "navigating to child window");

			driver.findElement(By.xpath("//a[text()='samsung']")).click();
			test.log(LogStatus.INFO, "click on samsung item name from child window");

			driver.switchTo().window(parentwinSessionId1);
			test.log(LogStatus.INFO, "navigating back to parent window");
           /*passing data into billing address field*/
         driver.findElement(By.name("bill_street")).sendKeys("whitefield");
 		test.log(LogStatus.INFO, "passing data into billing address field");
          /*passing data into shipping address field*/
			driver.findElement(By.name("ship_street" )).sendKeys("silkboard");
			test.log(LogStatus.INFO, "passing data into shipping address field");

			//driver.close();
			/*passing data into quantity field*/
         driver.findElement(By.id("qty1")).sendKeys("30");
 		test.log(LogStatus.INFO, "passing data into quantity field");
      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		test.log(LogStatus.INFO, "clicking on save button");
		/*modify the  created data */
       driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
       test.log(LogStatus.INFO, "click on edit button");
			driver.findElement(By.name("subject")).clear();
			test.log(LogStatus.INFO, "clear the subject name");
			driver.findElement(By.name("subject")).sendKeys("mobile");
			test.log(LogStatus.INFO, "change the subject as mobile");
		    driver.findElement(By.id("listPrice1")).sendKeys("40");
		    test.log(LogStatus.INFO, "add  the listprice");
			//driver.findElement(By.xpath("//b[text()='Total']")).click();
		    test.log(LogStatus.INFO,"click on total" );
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			test.log(LogStatus.INFO, "click on save button");
			
			String configMsg=driver.findElement(By.xpath("//span[text()='mobile -  Quote Information']")).getText();
			test.log(LogStatus.INFO, "getting confirmation text present ");
		       report.endTest(test);
			
		} 
			

			
		//Quotes settings click Announcement and update	
			@Test(groups={"SmokeTest"})
			public void QuotesSettingsTest()
			{
				ExtentTest test=report.startTest("QuotesSettingsTest");
				/*Identifying more drop down*/
				WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
				
				Actions act=new Actions(driver);
				act.moveToElement(wb).perform();
				test.log(LogStatus.INFO, "clicking on more drop down");

				driver.findElement(By.name("Quotes")).click();
				test.log(LogStatus.INFO, "identifying  and doing action on Quotes module under more drop down");
				  /* go to settings*/
				driver.findElement(By.xpath("//img[@src='themes/softed/images/settingsBox.png']")).click();
				test.log(LogStatus.INFO, "click on settings");
				driver.findElement(By.xpath("//a [@href='index.php?module=Settings&action=Announcements&parenttab=Settings']")).click();
				test.log(LogStatus.INFO, "click on announcement");
			   driver.findElement(By.id("announcement")).clear();
			   test.log(LogStatus.INFO,"clear the data" );
				driver.findElement(By.id("announcement")).sendKeys("yaminipriya");
				test.log(LogStatus.INFO,"create new announcement");
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			test.log(LogStatus.INFO, "click on update button");
			String configMsg=driver.findElement(By.xpath("//a[text()='Settings']")).getText();
			test.log(LogStatus.INFO, "getting  text present in announcement ");
		       report.endTest(test);
			
			
			
			}
					
			
					
				}



	


