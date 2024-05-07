package com.IVRM.Generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplimentation extends Baseclass implements ITestListener {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * Here this onTestFailure() will take screenshot whenever the test case become fail and attach that screenshot to mentioned path
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String cls=result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File f =new File("./src/test/resources/scr"+cls+".png");
		try {
			FileUtils.copyFile(src,f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Test Failed: " + result.getName());
    }
	
	/**
	 * Here this onTestStart() will print the time when actual test case execution start and that will print to both console and emailable report as well
	 */
	@Override
    public void onTestStart(ITestResult result) {
    	Reporter.log("Test started at: " + dateFormat.format(new Date()),true);
    }
	
	/**
	 * Here this onTestSuccess() will print the time when actual test case execution end and that will print to both console and emailable report as well
	 */
	@Override
    public void onTestSuccess(ITestResult result) {
		Reporter.log("Test ended at: " + dateFormat.format(new Date()),true);
    }

    


}



