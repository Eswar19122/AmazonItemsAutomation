package amazonautomationactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrimeMember {
	public WebDriver driver;

	public PrimeMember(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Locators and its WebElement
	@FindBy(css = "a[id='nav-link-amazonprime'] span[class='nav-icon nav-arrow']")       WebElement primeDropDown;
	@FindBy(xpath = "(//img[@id='multiasins-img-link'])[1]")                             WebElement redirectingToPrime;

//Actions And its implementation
	public void primeShow() {
		Actions a = new Actions(driver);
		a.moveToElement(primeDropDown).build().perform();
	}

	public void linkHere() {
		redirectingToPrime.click();
	}

}
