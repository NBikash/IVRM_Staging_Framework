package com.IVRM.pom;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IVRM.Generic.Generic;

public class LoginPage {
	Generic g=new Generic();
	/**
	 * This class contains all webElements present in Loginpage 
	 */
	@FindBy(id="login-username")
	private WebElement usernametbx;
	@FindBy(id="login-password")
	private WebElement pwdtbx;
	@FindBy(id="txtCaptcha")
	private WebElement captchatbx;
	@FindBy(id="txtInput")
	private WebElement txttbx;
	@FindBy(xpath="//b[text()='Sign in ']/..")
	private WebElement signinbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		Generic g=new Generic();
		g.implicitWait(10);
	}
	public void setlogin(String un,String pwd,WebDriver driver) throws InterruptedException{
		g.waitForVisibility(usernametbx, 10);
		usernametbx.sendKeys(un);
		g.waitForVisibility(pwdtbx, 10);
		pwdtbx.sendKeys(pwd);
		captchatbx.click();
		captchatbx.sendKeys(Keys.CONTROL+"a");
		g.DragAndDrop( captchatbx,txttbx);
		signinbtn.click();
		
		
		
	}

}
