package amazonautomationactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Items {
	public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Items(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Locators and its WebElement
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")                                                                                WebElement sonyBravia55Element;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")                                                                                                                                                                                                                            WebElement iphone13Element;
	@FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3']//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Sony Bravia 164 cm (65 inches) 4K Ultra HD Smart L')]")  WebElement sonyBravia65Element;	
	
//Actions
	public void getSonyBravia55() {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",sonyBravia55Element);
		sonyBravia55Element.click();
	}
	
	public void getIphone13() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",iphone13Element);
		iphone13Element.click();
	}
	
	public void getSonyBravia65() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",sonyBravia65Element);
		sonyBravia65Element.click();
	}
	
}
