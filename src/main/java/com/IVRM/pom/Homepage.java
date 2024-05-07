package com.IVRM.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.IVRM.Generic.Generic;

public class Homepage {
	Generic g=new Generic();
	/**
	 * This class contains all webElements present in Homepage
	 */
	@FindBy(xpath="//span[text()='Preadmission']/..")
	private WebElement Preadmissionmodule;
	@FindBy(xpath="//li[@class='treeview ng-scope active']/ul/li")
	private List<WebElement> submodulesofpreadmission;
	@FindBy(xpath="//span[text()='Application Form']/../..")
	private WebElement Applicationformsubmodule;
	@FindBy(xpath="//span[text()='Application Form']/../..//li")
	private WebElement Applicationformoption;
	@FindBy(xpath="//b[text()='Log-Out']/../..")
	private WebElement logoutbtn;
	@FindBy(xpath="//button[text()='Log Out']")
	private WebElement finallogout;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		Generic g=new Generic();
		g.implicitWait(10);
	}
	
	public void getpreadmissionmodule() {
		g.waitForInvisibility(By.id("preloader"), 10);
		Preadmissionmodule.click();
	}
	public void submoduleverification() {
		int count = submodulesofpreadmission.size();
		Reporter.log("we have "+count+" sub modules under Preadmission Module",true);
		for(int i=0;i<count;i++)
		{
			Reporter.log(submodulesofpreadmission.get(i).getText(),true);
		}
	}
	public void getapplicationformsubmodule() {
		g.waitForVisibility(Applicationformsubmodule, 10);
		Applicationformsubmodule.click();
	}
	public void getapplicationformoption() {
		g.waitForVisibility(Applicationformoption, 10);
		Applicationformoption.click();
	}
	public void logout() throws InterruptedException {
		g.waitForVisibility(logoutbtn, 10);
		logoutbtn.click();
		//Thread.sleep(5000);
		g.waitForVisibility(finallogout, 10);
		finallogout.click();
	}
	
	

}
