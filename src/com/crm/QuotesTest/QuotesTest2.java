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

public class QuotesTest2 extends BaseClass {
	@Test
	public void createQuotesTest()
	{
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.name("Quotes")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("subject")).sendKeys("laptop");
		driver.findElement(By.name("assigned_user_id")).click();
		driver.findElement(By.name("quotestage")).sendKeys("created");
	
		driver.findElement(By.xpath("//*[@id='single_accountid']/following-sibling::img ")).click();
		//capture session id
		Set<String>set=driver.getWindowHandles();
		//get the window count
		System.out.println(set.size());
		//capture session id from the set collection
		Iterator<String> it=set.iterator();
		String parentwinSessionId=it.next();
		String childwinSessionId=it.next();
		//pass driver control to child window
		driver.switchTo().window(childwinSessionId);
		//click "abc" in child window
		driver.findElement(By.linkText("abc")).click();
		//close child window
		//driver.close();
		
		driver.switchTo().alert().accept();
		driver.switchTo().window(parentwinSessionId);
	 driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
	 Set<String>set1=driver.getWindowHandles();
		//get the window count
		System.out.println(set1.size());
		//capture session id from the set collection
		Iterator<String> it1=set1.iterator();
		String parentwinSessionId1=it1.next();
		String childwinSessionId1=it1.next();
		//pass driver control to child window
		driver.switchTo().window(childwinSessionId1);
		driver.findElement(By.xpath("//a[text()='samsung']")).click();
		driver.switchTo().window(parentwinSessionId1);
		
		
		driver.findElement(By.name("bill_street")).sendKeys("whitefield");
		driver.findElement(By.name("ship_street" )).sendKeys("silkboard");
		
		//driver.close();
		driver.findElement(By.id("qty1")).sendKeys("30");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.findElement(By.xpath("//input[@title='Cancel [Alt+X]']")).click();
		
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		driver.findElement(By.name("subject")).clear();
		driver.findElement(By.name("subject")).sendKeys("mobile");
	    driver.findElement(By.id("listPrice1")).sendKeys("40");
		//driver.findElement(By.xpath("//b[text()='Total']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}
		

		
		
		@Test
		public void QuotesSettingsTest()
		{
		
			WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			Actions act=new Actions(driver);
			act.moveToElement(wb).perform();
			driver.findElement(By.name("Quotes")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/settingsBox.png']")).click();
			driver.findElement(By.xpath("//a [@href='index.php?module=Settings&action=Announcements&parenttab=Settings']")).click();
		   driver.findElement(By.id("announcement")).clear();
			driver.findElement(By.id("announcement")).sendKeys("yaminipriya");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		}
				
		
				
			}


	

		

