package com.sn.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sn.Commons.TestBase;



public class Listener extends TestBase implements ITestListener {
	
	ExtentReports extent=ExtendsReportGenarator.extentreprts();
	ThreadLocal<ExtentTest>extenttest = new ThreadLocal<ExtentTest>();
	
	
public void onTestSuccess(ITestResult result) {
	
	ObjectRepo.test.log(Status.PASS,"TEST CASE IS PASS");
	
	 ObjectRepo.test.addScreenCaptureFromBase64String(getCapture(),"test case passed ");
	 
//	 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	 String str=System.getProperty("user.dir")+"/test-output/Extent.html";
// File finaldestination =new File(str);
// try {
//	FileUtils.copyFile(scrFile, finaldestination);
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
	 
	
	}

public void onTestStart(ITestResult result) {
	ObjectRepo.test= extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
	extenttest.set(ObjectRepo.test);

	
}



public void onTestFailure(ITestResult result) {
	ObjectRepo.test.log(Status.FAIL,"TEST CASE IS fail " +result.getThrowable());
	
	 ObjectRepo.test.addScreenCaptureFromBase64String(getCapture(),"test case fail ");
	 
//	 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	 String str=System.getProperty("user.dir")+"/test-output/Extent.html";
// File finaldestination =new File(str);
// try {
//	FileUtils.copyFile(scrFile, finaldestination);
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
	
}

public void onTestSkipped(ITestResult result) {
	ObjectRepo.test.log(Status.SKIP,"TEST CASE IS SKIP");
	
	 ObjectRepo.test.addScreenCaptureFromBase64String(getCapture(),"test case skip ");
	 
//	 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	 String str=System.getProperty("user.dir")+"/test-output/Extent.html";
// File finaldestination =new File(str);
// try {
//	FileUtils.copyFile(scrFile, finaldestination);
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
	
}

public void onFinish(ITestContext context) {
	extent.flush();
	
}

public String getCapture() {
	
	String file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	return file;
}

}
