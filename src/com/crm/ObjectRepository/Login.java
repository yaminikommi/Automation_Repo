package com.crm.ObjectRepository;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.GenericLib.FileLib;

public class Login {
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;

	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public void loginToApp(String username,String password)
	{
		usernameEdit.sendKeys(username);
		 passwordEdit.sendKeys(password);
		 loginBtn.click();
	}
	public void loginToApp() throws Throwable
	{
    //FileLib f=new FileLib();
    Properties pObj=FileLib.getPropertiesObj();
    usernameEdit.sendKeys(pObj.getProperty("username"));
	 passwordEdit.sendKeys(pObj.getProperty("password"));
	 loginBtn.click();
   }
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
}