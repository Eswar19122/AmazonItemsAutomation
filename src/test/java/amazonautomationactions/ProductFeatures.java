package amazonautomationactions;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C://Users//puli.lokeswar//Downloads//chromedriver116-win32//chromedriver-win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.click();
		search.sendKeys("dell inspiron 3505");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2'] div[class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style'] span:nth-child(1)")).click();
		//WebElement see= driver.findElement(By.xpath("//a[@id='seeMoreDetailsLink']"));
		//WebElement seeman = driver.findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[2]"));
		driver.switchTo().activeElement().findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[2]")).getText();
		//seeman.getText();
		/*
		 * try { JavascriptExecutor script = (JavascriptExecutor) driver;
		 * script.executeScript("arguments[0].scrollIntoView(true);", seeman);
		 * seeman.click(); }catch(org.openqa.selenium.NoSuchElementException e) {
		 * JavascriptExecutor script = (JavascriptExecutor) driver;
		 * script.executeScript("arguments[0].scrollIntoView(true);", seeman);
		 * seeman.click(); }
		 */
		driver.quit();
	}
	

}
