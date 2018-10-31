package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")	
	private WebElement goToAdmin;
	@FindBy(name="Quotes")
	private WebElement Quoteslink;
	
	
	public WebElement getMoreDropDown() {
		return moreDropDown;
	}
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	public WebElement getGoToAdmin() {
		return goToAdmin;
	}
	public WebElement getQuotes() {
		return Quoteslink;
	}
	 
	
	
		
	

}
