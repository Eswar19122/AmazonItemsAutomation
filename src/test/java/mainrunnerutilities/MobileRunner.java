package mainrunnerutilities;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import amazonautomationactions.DriversFactory;
import amazonautomationactions.OnePlusMobile;

public class MobileRunner extends DriversFactory {
	WebDriver driver;
	OnePlusMobile mob;
	ExtentSparkReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;
	
    Logger log=(Logger) LogManager.getLogger(MobileRunner.class);
    
	@BeforeClass
	public void extentTo() {
			htmlReport = new ExtentSparkReporter("OnePlusUniquePrice.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReport);
	}
		
	@AfterClass
	public void extentOff() {
			 extent.flush();
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = landing(driver);
		mob = new OnePlusMobile(driver);
		log.info("Launching the Chrome browser");
		log.info("Taking Amazon URL from properties file");
		log.info("Navigating to Amazon Page");
	}
	
	@AfterMethod
	public void setOff() {
		tearDown(driver);
		log.info("Quiting from Chrome driver");
		test.log(Status.INFO,"Quiting from Chrome driver");
	}
	
	@Test
	public void mobilesHere()throws Exception  {
		log.info("Starting the test case for unique prices list for onePlus mobiles");
		test = extent.createTest("One Plus Mobiles","Searching for unique prices list for onePlus mobiles");
		test.log(Status.INFO,"Launching the Chrome browser");
		test.pass("Taking Amazon URL from properties file");
		test.log(Status.INFO,"Starting the test case for unique prices list for onePlus mobiles");
		mob.onePlusMobile();
		log.info("Clicking the mobiles button from main bar of amazon page");
		log.info("Clicking of Oneplus mobiles checkbox from mobiles checkboxes");
		test.pass("Clicking the mobiles button from main bar of amazon page");
		test.pass("Clicking of Oneplus mobiles checkbox from mobiles checkboxes");
		mob.uniquePriceCount();
		log.info("printing unique prices of list for OnePlus mobiles");
		test.pass("printing unique prices of list for OnePlus mobiles");
	}

}
;