package amazonautomationactions;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnePlusMobile {
	WebDriver driver;

	public OnePlusMobile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

//Locators and its WebElement
	@FindBy(xpath = "(//a[normalize-space()='Mobiles'])[1]")        WebElement mobileDropDown;
	@FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[6]")    WebElement checkBox;
	@FindAll(@FindBy(xpath = "//span[@class='a-price-whole']"))     List<WebElement> pricing;

//Actions and its implementation
	public void onePlusMobile() {
		mobileDropDown.click();
		checkBox.click();
	}

	public void uniquePriceCount() {
		HashSet<String> p = new HashSet<String>();
		for (WebElement price : pricing) {
			String a = price.getText();
			p.add(a);
		}
		System.out.println("Unique price one plus mobiles  are: "+ p.size());
	}
	
}
