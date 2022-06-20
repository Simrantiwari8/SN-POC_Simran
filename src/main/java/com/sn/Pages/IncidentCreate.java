
package com.sn.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sn.Commons.TestBase;

public class IncidentCreate extends TestBase{

	TestBase t = new TestBase();


	@FindBy(xpath = "//button[@class=\"selected_action action_context btn btn-primary\"]")
	WebElement CreateNewIncident;

	@FindBy(xpath = "//input[@id=\"sys_display.incident.caller_id\"]")
	WebElement Caller01;

	@FindBy(id = ("incident.short_description"))
	WebElement ShortDescription;



	@FindBy(xpath = "//*[@id=\"output_messages\"]/div/div/span[2]")
	WebElement Incidenterrormsg;

	@FindBy(id = "incident.number")
	WebElement Incidentnumber;

	@FindBy(id=("sysverb_insert_bottom"))
	WebElement ClickSub;



	@FindBy(linkText=("Inquiry / Help"))
	WebElement InquiryHelp;

	@FindBy( xpath ="//span[text()='Related Records']")
	WebElement relatedrecords;

	


	@FindBy( xpath ="//button[@id=\"sysverb_new\"]")
	WebElement newbutton;

	@FindBy(xpath = "/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement SearchButton;


	@FindBy(xpath = "/html/body/div[1]/span/span/nav/div/div[1]/button[2]")
	WebElement dropdown;
	
	@FindBy(xpath = "//div[normalize-space()='Create Normal Change']")
	WebElement normalchange;
	
	@FindBy(xpath = "//button[@id=\"sysverb_update\"]")
	WebElement chngupdatebutton;
	
	@FindBy( xpath ="//span[text()='Related Records']")
	WebElement clicktorelroc;
	
	@FindBy( xpath ="//button[@id=\"sysverb_update\"]")
	WebElement finalincupdate;

	
	@FindBy( xpath ="//input[@name=\"sys_display.incident.rfc\"]")
	WebElement getchangereqid;
	
	@FindBy(xpath = "//span[@class=\"outputmsg_text\"]")
	WebElement resolveNoteMsg;
	
//	@FindBy(id = "filter")
//	WebElement TypeIncident;
	
	
	@FindBy( xpath ="//input[@name=\"filter\"]")
	WebElement TypeIncident;
	
	@FindBy(xpath ="/html/body/div[5]/div/div/nav/div/div[3]/div/div/concourse-application-tree/ul/li[29]/ul/li[4]/div/div/a/div/div")
	WebElement changeall;
	
	
	
	public IncidentCreate ()
	{
		PageFactory.initElements(t.driver, this);
	}
	public String verifyincidentCreate()

	{
		return t.driver.getTitle();



	}





	public CreateChange incidentCreate01(String Caller,String Shortdiscription) throws InterruptedException
	{

		//ImplicitlyWait
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		System.out.println("==============================================================");

		System.out.println("THIS IS INCIDENTCREATE CLASS incidentCreate01 METHOD");

		System.out.println("-------------------------------------------------------------");

		//Switched on Zeroth index frame
		driver.switchTo().frame(0);
		System.out.println("Switched on Zeroth index frame");

		System.out.println("-------------------------------------------------------------");

		//Click new Button
		boolean createNewIncident_Button =CreateNewIncident.isDisplayed();
		System.out.println("Is CreateNewIncident_Button displayed  :"+ createNewIncident_Button);
		CreateNewIncident.click();
		System.out.println("Clicked on new Button");

		System.out.println("-------------------------------------------------------------");

		String IncidentNo = Incidentnumber.getAttribute("value");
		System.out.println("New Incident Number" +IncidentNo);

		System.out.println("-------------------------------------------------------------");

		//Send input in caller field
		boolean  Caller_Text_Field = Caller01.isDisplayed();
		System.out.println("Is Caller_Text_Field displayed  :"+ Caller_Text_Field );
		
		Caller01.clear();
		Caller01.sendKeys(Caller);
		System.out.println("Passed input in caller field from EXEL");

		System.out.println("-------------------------------------------------------------");

		//send input in ShortDescription field from EXEL
		boolean  shortdiscription_Field = ShortDescription.isDisplayed();
		System.out.println("Is shortdiscription_Field displayed  :"+ shortdiscription_Field );
		Thread.sleep(1000);
		if(Shortdiscription.isBlank())
		{
			ClickSub.click();
			String errmsg=resolveNoteMsg.getText();
			System.out.println("Error massage is      :"+errmsg);
			System.out.println("********Mandotory input of Shortdiscription is not availble in Excel File Name is TestData2 and sheet name is IncidentData *******");
			driver.quit();
		}
		else
		{
			ShortDescription.sendKeys(Shortdiscription);
			System.out.println("Resolve Info is entered");
		}
		
		//ShortDescription.sendKeys(Shortdiscription);
		System.out.println("Passed input in ShortDescription field from EXEL");

		System.out.println("-------------------------------------------------------------");

		ClickSub.click();
		System.out.println("Cliked on incident submit button");

		System.out.println("-------------------------------------------------------------");

		//search incident no
		SearchButton.sendKeys(IncidentNo);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		System.out.println("sended incident number in  search  field to search created incident number  ");

		System.out.println("-------------------------------------------------------------");

		//verify incident created or not
		String t = IncidentNo;
		if ( driver.getPageSource().contains( t)){
			System.out.println( t + ":  this number incident created succesfully");
			InquiryHelp.click();
		} else {
			System.out.println("incident not created");
		}

		System.out.println("-------------------------------------------------------------");
//
//		//scroll down page
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,900)");
//		System.out.println("scrolled down to click problembutton");
//
//		System.out.println("-------------------------------------------------------------");
//
//		//Click on RelatedRecords 
//		boolean  relatedrecords_Button = relatedrecords.isDisplayed();
//		System.out.println("Is relatedrecords_Button displayed  :"+  relatedrecords_Button );
//		relatedrecords.click();
//		System.out.println("Clicked on related records button");
//
//		System.out.println("-------------------------------------------------------------");
//
//		//click Problem_Button
//		boolean  problembutton_tab = problembutton.isDisplayed();
//		System.out.println("Is problem_Button displayed  :"+  problembutton_tab );
//		problembutton.click();
//		System.out.println("Clicked on Problem_Button");
//
//		System.out.println("-------------------------------------------------------------");
//
//		//Switch to new tab
//		String parantwindow =driver.getWindowHandle();
//		System.out.println("paraent windowID is  "+ parantwindow);
//		Set<String>handles=driver.getWindowHandles();
//		System.out.println(handles);
//		Iterator<String>it01=handles.iterator();
//		it01.next();
//		it01.next();
//		String wn3= it01.next();
//		driver.switchTo().window(wn3);
//		System.out.println("Switched on problemcreate page to crete Problem ");
//
//		System.out.println("-------------------------------------------------------------");
//
//		//Click new button on problem page
//		boolean  newbutton_tab = newbutton.isDisplayed();
//		System.out.println("Is New_Button displayed on ProblemPage :"+   newbutton_tab );
//		newbutton.click();
//		System.out.println("Clicked new button on problem page to crete Problem ");
//
//		System.out.println("-------------------------------------------------------------");
//
//
		
		
		//driver.switchTo().frame(0);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
		

		
		normalchange.click();
		
		

		
		chngupdatebutton.click();
		
		//Select select = new Select(dropdown);
		 //select.selectByIndex(7);
		
		//scroll down page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		System.out.println("scrolled down to click Related Records");

		System.out.println("-------------------------------------------------------------");

		clicktorelroc.click();
		
		String chngid = getchangereqid.getAttribute("value");
		System.out.println("New change request id created" +chngid);
		
		finalincupdate.click();
		
		
		Set<String>handles01=driver.getWindowHandles();
		System.out.println(handles01);
		Iterator<String>it02=handles01.iterator();
		it02.next();
		String wn4= it02.next();
		driver.switchTo().window(wn4);
		
        
		
		System.out.println("-------------------------------------------------------------");
	
		
		

		//send change keyword in navigator field
		Set<String>handles=driver.getWindowHandles();
	    System.out.println(handles);
		Iterator<String>it=handles.iterator();
		it.next();
		String wn2= it.next();
		driver.switchTo().window(wn2);
		TypeIncident.clear();
		TypeIncident.sendKeys("change");
		//TypeIncident.sendKeys("1123");

		System.out.println("entered change keyword in navigator");

		System.out.println("-------------------------------------------------------------");

	//click first Problem AND Next All field
		changeall.click();
		System.out.println("Clicked FRIST change AND Next All field");

		System.out.println("-------------------------------------------------------------");

		//Send Already Created problem number to search
		driver.switchTo().frame(0);
	SearchButton.sendKeys(chngid);
		//SearchButton.sendKeys("12345678");
	Actions acts = new Actions(driver);
		acts.sendKeys(Keys.ENTER).build().perform();
		System.out.println("Enterd Already Created change number to search");

		System.out.println("-------------------------------------------------------------");

		//verify problem created or not
		String ts = chngid;
		if ( driver.getPageSource().contains( ts)){
		System.out.println( ts + ":  this number change created succesfully");

		} else {
		System.out.println("change not created ");
		}

		System.out.println("-------------------------------------------------------------");			
		
		
		return new CreateChange();
		

	}
	
	public void InvalidIncidentcreate(String Caller, String Shortdiscription) throws InterruptedException
	{
		driver.switchTo().frame(0);
		CreateNewIncident.click();
		String IncidentNo = Incidentnumber.getAttribute("value");
		System.out.println(IncidentNo);
		Caller01.clear();
		Caller01.sendKeys(Caller);
		
		ShortDescription.sendKeys(Shortdiscription);
		
		ClickSub.click();
		String incidenterror = Incidenterrormsg.getText();
		System.out.println("Error msg is:" +incidenterror );
		Assert.assertEquals(incidenterror, "The following mandatory fields are not filled in: Caller", "Test failed");
	}
}

