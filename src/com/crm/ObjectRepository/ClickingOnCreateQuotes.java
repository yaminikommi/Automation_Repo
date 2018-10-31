package com.crm.ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickingOnCreateQuotes {
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
   private WebElement clickOnSave;

	public WebElement getClickOnSave() {
		return clickOnSave;
	}
	public String getAlertMsg()
	{
		Alert a1=BaseClass1.driver.switchTo().alert();
		String msg="a1.getText()";
		return msg;
		
	}
	public void getAlertAccept()
	{
		Alert a1=BaseClass1.driver.switchTo().alert();
		 a1.accept();
	}
	}	
		
	


