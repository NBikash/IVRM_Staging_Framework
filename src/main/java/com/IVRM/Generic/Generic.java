package com.IVRM.Generic;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Generic extends Baseclass {
	
	
	/**
	 * This is the generic method for select value from a dropdown through value
	 * @param address
	 * @param value
	 */
	public void listboxbyvalue(WebElement address,String value)
	{
		Select s=new Select(address);
		s.selectByValue(value);
		
	}
	
	/**
	 * This is the generic method for selecting value from a dropdown through visible text
	 * @param address
	 * @param text
	 */
	public void listboxbyvisbletext(WebElement address,String text)
	{
		Select s=new Select(address);
		s.selectByValue(text);
		
	}
	
	/**
	 * This is the generic method for select value from a dropdown through index
	 * @param address
	 * @param index
	 */
	public void listboxbyindex(WebElement address,int index)
	{
		Select s=new Select(address);
		s.selectByIndex(index);
		
	}
	
	/**
	 * This is the generic method for MouseHover
	 * @param element
	 */
	public void mousehover(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();;
				
	}
	
	/**
	 * This is the generic method for RightClick
	 */
	public void rightclick() {
		Actions a=new Actions(driver);
		a.contextClick().perform();;
	}
	
	/**
	 * This is the generic method for Drag and Drop
	 * @param src
	 * @param dest
	 */
	public void DragAndDrop(WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();;
		
	}
	
	/**
	 * This is the generic method for implicitWait
	 * @param sec
	 */
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	/**
	 * method to get title of current webpage
	 * @return String name of a webpage
	 */
	public String getTitle(){
		return driver.getTitle();
	}
	
	/**
	 * method to click on an element using javascript
	 * @param element to be clicked
	 */
	public void clickOnElementUsingJs(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	/**
	 *  method to wait for an element to be visible
	 * @param targetElement element to be visible
	 * @return true if element is visible else
	 * @throws TimeoutException 
	 */
	public boolean waitForVisibility(WebElement targetElement,int sec) throws TimeoutException {
		try{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOf(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	
	/**
	 *  method to wait for an element to be clickable
	 * @param targetElement element to be clickable
	 * @return true if element is clickable else throws TimeoutException
	 */
	public boolean waitForElementToBeClickable(By targetElement,int sec) {
		try{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not clickable: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	
	
	/**
	 *  method to wait for an element until it is invisible
	 * @param targetElement element to be invisible
	 * @return true if element gets invisible else throws TimeoutException
	 */
	public boolean waitForInvisibility(By targetElement,int sec) {
		try{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec) );
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is still visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	
	/**
	 * method to check value contained in list elements and click on it
	 * @param fetchedListElements List of fetched value
	 * @param valueToBeContained value to be contained in list elements
	 */
	public void clickOnContainingValue(List<WebElement> fetchedListElements, String valueToBeContained){

		for (WebElement element : fetchedListElements) {
			if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
				element.click();
				//System.out.println("Trying to select: "+valueToBeContained );
				return;
			}
			
		}
	}
	
	/**
	 * method to match value with list elements and click on it
	 * @param fetchedListElements List of fetched value
	 * @param valueToBeMatched value to be matched with list elements
	 */
	public void clickOnMatchingValue(List<WebElement> fetchedListElements, String valueToBeMatched){

		for (WebElement element : fetchedListElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
				element.click();
				return;      
			}
			
		}
	}
	
	/**
	 * method to wait until page is loaded completely
	 * @param PageName String name of current webpage
	 */
	public void waitForPageToLoad(String PageName) {
		String pageLoadStatus;
		JavascriptExecutor js;

		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String)js.executeScript("return document.readyState");
			
		} while ( !pageLoadStatus.equals("complete") );
		
	}
	
	/**
	 * To verify whether element is displaying or  not 
	 * @param element
	 */
	public void isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			assertTrue(true);
		}
		catch (Exception e) {
			e.printStackTrace();
      Reporter.log(element+"Element is not displaying");
		}
	}
	
	/**
	 * This is the generic method to verify Page w.r.t Actual and Expected
	 * @param actual
	 * @param expected
	 */
	public void pageverification(String actual,String expected) {
		SoftAssert s=new SoftAssert();
		try {	
		s.assertEquals(actual, expected);
		s.assertAll();
		}
		catch(AssertionError e)
		{
			Reporter.log("Expected "+expected+"but showing "+actual,true);
			e.printStackTrace();
			      
		    } 
		
		
	}
	
	 /**
     * This is the Generic customized method designed to handle synchronization issue based on iteration
     * @param j  i.e. iteration count
     * @param element  
     */
		
	public void CustomWait(int j,WebElement element) {
		int i=1;
		while(i<=j) {
		try {
			element.click();
			break;
		}
		catch(Exception e)
		{
			i++;
		}
		}
	}
	
	/**
	 * This is the Generic method designed to take screenshot 
	 * @return path name where screenshot stored
	 */
	public String failscreenshot() {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File f =new File("./src/test/resources/Failscr.png");
		String path=f.getAbsolutePath();
		
		try {
			FileUtils.copyFile(src,f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
	 


}



