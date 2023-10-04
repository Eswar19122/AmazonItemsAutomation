package mainrunnerutilities;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import amazonautomationactions.DriversFactory;
import amazonautomationactions.EnterItem;

public class SearchingProduct extends DriversFactory {
	WebDriver driver;
	EnterItem productInfo;
	ExtentSparkReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;
	
	Logger log = (Logger) LogManager.getLogger(MobileRunner.class);
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = landing(driver);
		productInfo = new EnterItem(driver);
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
	
	@BeforeSuite
	public void Extent() {
			htmlReport = new ExtentSparkReporter("ProductsList.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReport);
	}
		
	@AfterSuite
	public void Extentoff() {
			 extent.flush();
	}


	@Test(priority = 1)
	public void searchSony55() throws Exception {
		test = extent.createTest("Sony Bravia 55","Test to price of Sony Bravia 55");
		test.log(Status.INFO,"Launching Chrome Driver");
		test.pass("Taking Amazon URL from properties file");
		test.log(Status.INFO,"Starting the First test case");
		log.info("Starting the First test case");
		productInfo = new EnterItem(driver);
		productInfo.searching();
		log.info("Taking Sony Bravia 55 from Excel and Entering in search box");
		log.info("Searching for Sony Bravia 55");
		test.pass("Taking Sony Bravia 55 from Excel and Entering in search box");
		test.pass("Searching for Sony Bravia 55");
		productInfo.searchSonyBravia55();
		log.info("Sony Bravia 55inches TV price is printing in Excel");
		test.pass("Sony Bravia 55inches TV price is printing in Excel");	
	}
	
	@Test(priority = 2)
	public void searchIphone() throws Exception {
		test = extent.createTest("Iphone 13","Test to Iphone 13");
		test.log(Status.INFO,"Launching Chrome Driver");
		test.pass("Taking Amazon URL from properties file");
		log.info("Starting the Second test case");
		test.log(Status.INFO,"Starting the Second test case");
		productInfo = new EnterItem(driver);
		productInfo.searching();
		test.pass("Taking Iphone 13 from Excel and Entering in search box");
		test.pass("Searching for IPhone 13");
		log.info("Taking Iphone 13 from Excel and Entering in search box");
		log.info("Searching for IPhone 13");
		productInfo.searchIphone13();
		log.info("IPhone 13 price is printing in Excel");
		test.pass("IPhone 13 price is printing in Excel");
	}
	
	@Test(priority = 3)
	public void searchSony65() throws Exception {
		test = extent.createTest("Sony Bravia 65","Test to Sony Bravia 65");
		test.log(Status.INFO,"Launching Chrome Driver");
		test.pass("Taking Amazon URL from properties file");
		log.info("Starting the Third test case");
		test.log(Status.INFO,"Starting the Third test case");
		productInfo = new EnterItem(driver);
		productInfo.searching();
		log.info("Taking Sony Bravia 65 from Excel and Entering in search box");
		log.info("Searching for Sony Bravia 65");
		test.pass("Taking Sony Bravia 65 from Excel and Entering in search box");
		test.pass("Searching for Sony Bravia 65");
		productInfo.searchSonyBravia65();
		log.info("Sony Bravia 65 TV price is printing in Excel");
		test.pass("Sony Bravia 65 TV price is printing in Excel");	
	}
	
	@Test(priority = 4)
	public void searchNokiaTV() throws Exception {
		test = extent.createTest("NOKIA TV","Test to NOKIA TV ");
		test.log(Status.INFO,"Launching Chrome Driver");
		test.pass("Taking Amazon URL from properties file");
		log.info("Starting the Fourth test case");
		test.log(Status.INFO,"Starting the Fourth test case");
		productInfo = new EnterItem(driver);
		productInfo.searching();
		log.info("Taking NOKIA TV from Excel and Entering in search box");
		log.info("Searching for NOKIA TV");
		test.pass("Taking NOKIA TV from Excel and Entering in search box");
		test.pass("Searching for NOKIA TV");
		productInfo.searchNokiaTV();
		log.error("NOKIA TV  is not there");
		test.fail("NOKIA TV  is not there");
	}
	
}
