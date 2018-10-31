package com.crm.ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class CreatingNewQuotePage
{
	@FindBy(xpath="themes/softed/images/btnL3Add.gif")
	private WebElement clickcreateQuotes;
	@FindBy(name="subject")
	private WebElement subjectnameEdit;
	@FindBy(name="assigned_user_id")
	private WebElement AssignedDropdown;
	@FindBy(name="quotestage")
	private WebElement QuoteStageDropDown;
	@FindBy(xpath="//*[@id='single_accountid']/following-sibling::img")
	private WebElement OrganizationLookUp;
	@FindBy(xpath="//a[text()='xyz']")
	private WebElement SelectOrganizationLookUp;
	@FindBy(name="bill_street")
	private WebElement BillingAddressEdit;
	@FindBy(name="ship_street")
	private WebElement ShippingAddressEdit;
	@FindBy(xpath="//img[@src='themes/images/products.gif']")
	private WebElement ItemNameLookUp;
	@FindBy(xpath="//a[text()='samsung']")
	private WebElement SelectItemNameLookUp;
	@FindBy(id="qty1")
	private WebElement QtyEdit;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickonsavebutton;
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement clickoncancelbutton;
	
	public WebElement getClickcreateQuotes() {
		return clickcreateQuotes;
	}
	public WebElement getSubjectnameEdit() {
		return subjectnameEdit;
	}
	public WebElement getAssignedDropdown() {
		return AssignedDropdown;
	}
	public WebElement getQuoteStageDropDown() {
		return QuoteStageDropDown;
	}
	public WebElement getOrganizationLookUp() {
		return OrganizationLookUp;
	}
	public WebElement getSelectOrganizationLookUp() {
		return SelectOrganizationLookUp;
	}

	public WebElement getBillingAddressEdit() {
		return BillingAddressEdit;
	}
	public WebElement getShippingAddressEdit() {
		return ShippingAddressEdit;
	}
	public WebElement getItemNameLookUp() {
		return ItemNameLookUp;
	}
	public WebElement getSelectItemNameLookUp()
	{
		return SelectItemNameLookUp;
	}
	public WebElement getClickonsavebutton() {
		return clickonsavebutton;
	}
	public WebElement getClickoncancelbutton()
	{
		return clickoncancelbutton;
	}
	public WebElement getQty1Edit() {
		return QtyEdit;
	}
	public String getAlertMsg()
	{
		Alert a1=BaseClass1.driver.switchTo().alert();
		return a1.getText();
	}
	public void getAlertAccept()
	{
		Alert a1=BaseClass1.driver.switchTo().alert();
		a1.accept();
	}
	
}
		
	
	
