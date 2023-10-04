package mainrunnerutilities;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import amazonautomationactions.DriversFactory;
import amazonautomationactions.PrimeMember;

public class PrimeRunner extends DriversFactory {
	WebDriver driver;
	PrimeMember prime;
	ExtentSparkReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;
	
	Logger log = (Logger) LogManager.getLogger(PrimeMember.class);
	
	@BeforeSuite
	public void extentTo() {
			htmlReport = new ExtentSparkReporter("PrimeShowing.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReport);
	}
		
	@AfterSuite
	public void extentOff() {
			 extent.flush();
	}

	@BeforeClass
	public void setUp() throws IOException {
		driver = landing(driver);
		//prime = new PrimeMember(driver);
		log.info("Launching the Chrome browser");
		log.info("Taking Amazon URL from properties file");
		log.info("Navigating to Amazon Page");
	}

	@AfterClass
	public void setOff() {
		tearDown(driver);
		log.info("Quiting from Chrome driver");
		test.log(Status.INFO,"Quiting from Chrome driver");
	}
	
	@Test
	public void show() {
		test = extent.createTest("Amazon Prime", "Amazon Prime showing");
		test.log(Status.INFO,"Launching the Chrome browser");
		test.pass("Taking Amazon URL from properties file");
		prime = new PrimeMember(driver);
		log.info("Starting the test case for showing Amazon Prime page");
		test.log(Status.INFO,"Starting the test case for showing Amazon Prime page");
		prime.primeShow();
		log.info("Showing Amazon prime dropdown");
		test.pass("Showing Amazon prime dropdown");
		prime.linkHere();
		log.info("Showing Amazon prime main page");
		test.pass("Showing Amazon prime main page");
	}

}
