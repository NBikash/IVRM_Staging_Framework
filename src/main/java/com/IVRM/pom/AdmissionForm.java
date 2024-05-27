package com.IVRM.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.IVRM.Generic.FileLibrary;
import com.IVRM.Generic.Generic;
/**
 * This class contains all webElements present in Application form page
 * Test case repository path: Y:\Test Case Documents for all Modules\IVRM Modules\Pre-Admission
 * @author Test case owner : Chethan D
 * @author Test script owner : Bikash 
 */
public class AdmissionForm  {
	Generic g=new Generic();
	
	@FindBy(xpath="//input[@name='hname']")
	private WebElement nameofchildtbx;
	@FindBy(xpath="//select[@name='hreligion']")
	private WebElement religiondd;
	@FindBy(xpath="//select[@name='casteere']")
	private WebElement castedd;
	@FindBy(xpath="//select[@name='hgender']")
	private WebElement genderdd;
	
	//select dob 
	@FindBy(xpath="//md-datepicker[@name='bdate']/button")
	private WebElement dobcalender;
	@FindBy(xpath="//md-calendar//tbody[4]/tr[1]/td/md-icon")
	private WebElement currentmonthyearmdicon;
	@FindBy(xpath="//td[@aria-label='February 2013']")
	private WebElement actualdobmonth;
	@FindBy(xpath="//td[@aria-label='Monday February 4 2013']")
	private WebElement actualdobdate;
	
	//student photo
	@FindBy(xpath="//input[@name='file1']")
	private WebElement studentphoto;
	
	@FindBy(xpath="//select[@name='happlygg']")
	private WebElement classdd;
	@FindBy(xpath="//select[@name='hnationality']")
	private WebElement nationalitydd;
	@FindBy(name="hmothertongue")
	private WebElement mothertonguetbx;
	
	@FindBy(xpath="//select[@name='stubloodgrp']")
	private WebElement bloodgrpdd;
	
	@FindBy(xpath="//input[@name='hconstreet']")
	private WebElement streettbx;
	@FindBy(xpath="//input[@name='hconarea']")
	private WebElement areatbx;
	@FindBy(xpath="//select[@name='hconcountry']")
	private WebElement countrydd;
	@FindBy(xpath="//select[@name='hconstate']")
	private WebElement statedd;
	@FindBy(xpath="//input[@name='City']")
	private WebElement citytbx;
	@FindBy(xpath="//input[@name='pincode']")
	private WebElement pincodetbx;
	@FindBy(xpath="//span[text()='Permanent Address Same As Residential Address']/../input")
	private WebElement residentaddresscheckbox;
	
	@FindBy(xpath="//input[@name='hfathername']")
	private WebElement fathernabetbx;
	@FindBy(xpath="//input[@name='qual']")
	private WebElement fatherqualificationtbx;
	@FindBy(xpath="(//span[@class='lbl padding-8'])[5]")
	private WebElement fatheroccupationrdbtn;
	@FindBy(xpath="//input[@name='haadharfather']")
	private WebElement fatheraadharnotbx;
	@FindBy(xpath="//select[@name='hreligionfather']")
	private WebElement fatherreligiondd;
	@FindBy(xpath="//select[@name='casteerefather']")
	private WebElement fatherrcastedd;
	@FindBy(xpath="//select[@name='adasdfsd']")
	private WebElement fathernationalitydd;
	@FindBy(name="hFpno")
	private WebElement fathermobno;
	
	@FindBy(name="hmothername")
	private WebElement mothernametbx;
	@FindBy(name="motquali")
	private WebElement motherqualificationtbx;
	@FindBy(xpath="(//span[@class='lbl padding-8'])[10]")
	private WebElement motheroccupationrdbtn;
	@FindBy(name="haadharmoth")
	private WebElement motheraadharnotbx;
	@FindBy(xpath="//select[@name='hreligionmother']")
	private WebElement motherreligiondd;
	@FindBy(xpath="//select[@name='casteeremother']")
	private WebElement mothercastedd;
	@FindBy(xpath="//select[@name='motnation']")
	private WebElement mothernationalitydd;
	@FindBy(name="hMpno")
	private WebElement mothermobno;
	
	@FindBy(xpath="//input[@name='hpno']")
	private WebElement mobnoforsendingsms;
	@FindBy(xpath="(//input[@id='reservation'])[1]")
	private WebElement mailidforcommunication;
	
	@FindBy(name="fathmoninco")
	private WebElement fathermonthlyincome;
	@FindBy(name="mothincome")
	private WebElement mothermonthlyincome;
	
	@FindBy(xpath="(//strong[text()='Undertaking by the Parents/Guardian :']/../..//span[text()='Yes'])[1]")
	private WebElement undertakingyesrdbtn;
	
	@FindBy(xpath="//button[@ng-click='savestudentdata()']")
	private WebElement finalsavebtn;
	
	
	public AdmissionForm(WebDriver driver) {
		PageFactory.initElements(driver, this);		
		g.implicitWait(10);
	}
	FileLibrary f=new FileLibrary();
	public void setchildname() throws EncryptedDocumentException, IOException {
		g.waitForVisibility(nameofchildtbx, 10);
		String name=f.readExcel("Sheet1", 1, 0);
		nameofchildtbx.sendKeys(name);
	}
	public void getreligion() {
		g.listboxbyvalue(religiondd,"1");
	}
	public void getcaste() {
		g.listboxbyvalue(castedd, "86");
	}
	public void getgender() {
		g.listboxbyvisbletext(genderdd, "Female");
	}
	public void setdob() throws AWTException, InterruptedException {
	
		dobcalender.click();
		g.waitForVisibility(currentmonthyearmdicon, 10);
		currentmonthyearmdicon.click();
		Robot r=new Robot();
		 for (int i = 0; i < 22; i++) {
	            r.keyPress(KeyEvent.VK_UP);
	            r.delay(100); 
	            r.keyRelease(KeyEvent.VK_UP);
		 }
		 g.waitForVisibility(actualdobmonth, 10);
		 actualdobmonth.click();
		 g.waitForVisibility(actualdobdate, 10);
		 actualdobdate.click();
	}
	public void getclass() {
		g.waitForVisibility(classdd, 10);
		g.listboxbyvalue(classdd,"4");
	}
	public void getnationality() {
		g.listboxbyvalue(nationalitydd,"101");
	}
	public void setlanguage() throws EncryptedDocumentException, IOException
	{
		String language = f.readExcel("Sheet1", 1, 1);
		mothertonguetbx.sendKeys(language);
	}
	public void setstudentphoto() {
		File f=new File("./src/test/resources/student.png");
		String path = f.getAbsolutePath();
		studentphoto.sendKeys(path);
	}
	public void setbloodgrp() {
		g.waitForVisibility(bloodgrpdd, 10);
		g.listboxbyvalue(bloodgrpdd, "B+");
	}
	public void residenceadress() throws  IOException {
		String street = f.readExcel("Sheet1", 1, 2);
		streettbx.sendKeys(street);
		String area = f.readExcel("Sheet1", 1, 3);
		areatbx.sendKeys(area);
		g.listboxbyvalue(countrydd, "101");
		g.listboxbyvalue(statedd, "16");
		String city = f.readExcel("Sheet1", 1, 4);
		citytbx.sendKeys(city);
		double pin = f.readnumExcel("Sheet1", 1, 5);
		String pin1=String.valueOf(pin);
		pincodetbx.sendKeys(pin1);	
		g.CustomWait(500,residentaddresscheckbox );
		
		
	}
	public void fatherdetails() throws EncryptedDocumentException, IOException {
		fathernabetbx.sendKeys(f.readExcel("Sheet1", 1, 6));
		fatherqualificationtbx.sendKeys(f.readExcel("Sheet1", 1, 7));
		fatheroccupationrdbtn.click();
		fatheraadharnotbx.sendKeys(f.readExcel("Sheet1", 1, 8));
		g.listboxbyvalue(fatherreligiondd, "1");
		g.listboxbyvalue(fatherrcastedd,"86");
		g.listboxbyvalue(fathernationalitydd,"101");
		double fathermob = f.readnumExcel("Sheet1", 1, 9);
		String mobno=String.valueOf(fathermob);
		fathermobno.sendKeys(mobno);
		
	}
	public void motherdetails() throws EncryptedDocumentException, IOException {
		mothernametbx.sendKeys(f.readExcel("Sheet1", 1, 10));
		motherqualificationtbx.sendKeys(f.readExcel("Sheet1", 1, 11));
		motheroccupationrdbtn.click();
		motheraadharnotbx.sendKeys(f.readExcel("Sheet1", 1, 12));
		g.listboxbyvalue(motherreligiondd, "1");
		g.listboxbyvalue(mothercastedd,"86");
		g.listboxbyvalue(mothernationalitydd,"101");
		double mothermob = f.readnumExcel("Sheet1", 1, 13);
		String mobno=String.valueOf(mothermob);
		mothermobno.sendKeys(mobno);
	}
	
	public void setsmsemailalert() throws EncryptedDocumentException, IOException {
		double smsno = f.readnumExcel("Sheet1", 1, 14);
		String smsmob=String.valueOf(smsno);
		mobnoforsendingsms.sendKeys(smsmob);
		mailidforcommunication.sendKeys(f.readExcel("Sheet1", 1, 15));
	}
	
	public void setmonthlyincime() throws EncryptedDocumentException, IOException {
		double fathermo = f.readnumExcel("Sheet1", 1, 16);
		String fatherincome=String.valueOf(fathermo);
		fathermonthlyincome.sendKeys(fatherincome);
		double mothermo = f.readnumExcel("Sheet1", 1, 17);
		String motherincome=String.valueOf(mothermo);
		mothermonthlyincome.sendKeys(motherincome);
	}
	public void getdeclaration() {
		undertakingyesrdbtn.click();
	}
	public void getsave() {
		finalsavebtn.click();
	}
	          
	
	
	
	
	
	
	
	

}
