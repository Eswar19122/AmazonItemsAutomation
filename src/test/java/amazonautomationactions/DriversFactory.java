	package amazonautomationactions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriversFactory {
	public static WebDriver driver;
	
	@SuppressWarnings("static-access")
	public WebDriver landing(WebDriver driver) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C://Users//puli.lokeswar//eclipse-workspace//AmazonProductsAutomation//src//test//java//myData.properties");
		Properties P = new Properties();
		P.load(fis);
		this.driver = driver;
		System.setProperty("webdriver.chrome.driver",
				"C://Users//puli.lokeswar//Downloads//chromedriver-win32 (1)//chromedriver-win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(P.getProperty("amazonURL"));
		return driver;
	}
	
	public void tearDown(WebDriver driver) {
		driver.quit();
	}
}
