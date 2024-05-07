package com.IVRM.Generic;
import org.openqa.selenium.Dimension;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.IVRM.pom.Homepage;
import com.IVRM.pom.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * This is the generic class contains all the configuration methods
 * @author Bikash 
 */


public class Baseclass {
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	FileLibrary f=new FileLibrary();
	
	@BeforeTest
	public void BeforeTest() {
		extent.attachReporter(spark);
	}
	
	/**
	 * Here it will open Browser and verify Login page name 
	 * @throws IOException
	 */
	@BeforeClass
	public void openbrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Dimension size = new Dimension(1920, 1080);
		driver.manage().window().setSize(size);
		String url=f.readproperty("url");
		driver.get(url);
		Reporter.log("open browser",true);

		String exp=driver.getTitle();
		String act="I-Vidyalaya Resource Management (ERP)";
		Generic g=new Generic();
		g.pageverification(act, exp);
		Reporter.log("page verified",true);
		
	}
	
	/**
	 * Here it will login to staging link Admin portal with valid credentials 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		FileLibrary f=new FileLibrary();
		String un=f.readproperty("un");
		String pwd=f.readproperty("pwd");
		LoginPage l=new LoginPage(driver);
		l.setlogin(un, pwd, driver);
		Reporter.log("Login successfully",true);
		
		}
	
	/**
	 * Here this logout() should logout from Admin portal after execution of per testcase
	 * @throws InterruptedException
	 */
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Homepage h=new Homepage(driver);
		h.logout();
		Reporter.log("logout",true);
				
	}
	
	/**
	 * Here it will close the browser after logout 
	 */
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		Reporter.log("closeBrowser",true);
	}
	
	/**
	 * Here it will collect the execution report and flush it to extent report 
	 */
	@AfterTest
	public void AfterTest() {
		extent.flush();
	}

}
