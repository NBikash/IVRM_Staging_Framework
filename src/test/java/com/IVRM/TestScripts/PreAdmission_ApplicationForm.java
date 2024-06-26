package com.IVRM.TestScripts;

import java.awt.AWTException;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.IVRM.Generic.Baseclass;
import com.IVRM.pom.AdmissionForm;
import com.IVRM.pom.Homepage;
import com.IVRM.Generic.Generic;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
/**
 * Test script for Preadmission Application form
 * Test case repository path: Y:\Test Case Documents for all Modules\IVRM Modules\Pre-Admission
 * @author Test case owner : Chethan D
 * @author Test script owner : Bikash 
 */
@Listeners(com.IVRM.Generic.ListenerImplimentation.class)
public class PreAdmission_ApplicationForm extends Baseclass {
	@Test(groups={"smoke","regression"},priority = 0)
	public void Applicationform() throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		Generic g=new Generic(); 
				
		ExtentTest test=extent.createTest("Application Form");
		test.assignAuthor("Bikash").assignCategory("Smoke Test").assignDevice("Chrome");
		test.log(Status.INFO,"Application Form fillup");
		
		try {
		Homepage hm=new Homepage(driver);
		hm.getpreadmissionmodule();
		hm.submoduleverification();
		hm.getapplicationformsubmodule();
		hm.getapplicationformoption();
		AdmissionForm a=new AdmissionForm(driver);
		a.setchildname();
		a.getreligion();
		a.getcaste();
		a.getgender();
		a.setdob();
		a.getclass();
		a.getnationality();
		a.setlanguage();
		a.setstudentphoto();
		a.setbloodgrp();
		a.residenceadress();
		a.fatherdetails();
		a.motherdetails();
		a.setsmsemailalert();
		a.setmonthlyincime();
		a.getdeclaration();
		}
		catch (WebDriverException e) {	        
            e.printStackTrace();
            test.fail("Test Failed due to----->"+e.getMessage());
            String p= g.failscreenshot();
            test.log(Status.WARNING,"Failed Test case Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(p).build());
            Assert.fail();
        }
		catch(Exception e) {
			e.printStackTrace();
			test.fail("Test failed due to ----->"+e.getMessage());
			String p= g.failscreenshot();			 
            test.log(Status.WARNING,"Failed Test case Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(p).build());
            Assert.fail();
		}

		
	}

}
