package amazonautomationactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import excelutilities.AmazonExcelReader;

public class ItemPrice extends AmazonExcelReader{
	public WebDriver driver;
    String r;
    String sy;
    String rs;
    
	public ItemPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Locators and its webElement
	@FindBy(xpath = "(//span[@class='a-price-symbol'][contains(text(),'₹')])[3]")       	                                          WebElement rupeeSymbol;
	@FindBy(xpath = "//span[normalize-space()='56,990']")                                                                             WebElement digitsSony55;
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")                                                                            WebElement digitsIphone;
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")                                                                            WebElement digitsSony65;
	
//Actions and its implementation
	public String getPriceSonyBravia55() {
		sy = rupeeSymbol.getText();
		rs = digitsSony55.getText();
		System.out.println("Sony Bravia 55inches price is: "+sy+rs);
		r=sy+rs;
		return r;
	}
	
	public String getPriceIphone13() {
		sy = rupeeSymbol.getText();
		rs = digitsIphone.getText();
		System.out.println("Iphone13 price is: "+sy+rs);
		r=sy+rs;
		return r;
	}
	
	public String getPriceSonyBravia65() {
		sy = rupeeSymbol.getText();
		rs = digitsSony65.getText();
		System.out.println("Sony Bravia 65inches price is: "+sy+rs);
		r=sy+rs;
		return r;
	}	
		

}
