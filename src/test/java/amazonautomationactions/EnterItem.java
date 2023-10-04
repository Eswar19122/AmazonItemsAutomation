package amazonautomationactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import excelutilities.AmazonExcelWriter;
import excelutilities.AmazonExcelReader;


public class EnterItem extends AmazonExcelReader {
	String[][] dataRef = new String[10][10];
	WebDriver driver;
	Items item;
	ItemPrice price;
	String d;
	String excelPath="C://Users//puli.lokeswar//eclipse-workspace//AmazonProductsAutomation//src//main//java//excelsheet//AmazonSearchEntry.xlsx" ;   
	AmazonExcelWriter aew=new AmazonExcelWriter();  
	 
	public EnterItem(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Locators and its WebElement
	@FindBy(id = "twotabsearchtextbox")       	                   WebElement searchHere;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")     WebElement enterSearch;
   
//Actions and its implementation
	public void searching() throws Exception {
		dataRef = readExcel(excelPath,dataRef);
		item=new Items(driver);
		price=new ItemPrice(driver);
		searchHere.click();
	}
	
	@SuppressWarnings("static-access")
	public void searchSonyBravia55()throws Exception{
				String name = dataRef[0][0];
				try {
		          searchHere.sendKeys(name);
		          enterSearch.click();
		          item.getSonyBravia55();
		          Thread.sleep(5000);
		          d = price.getPriceSonyBravia55();
		          aew.WriteExcel(excelPath,0,1,d);
		          Assert.assertEquals("Sony bravia 55",name);
				}
				catch(org.openqa.selenium.ElementClickInterceptedException e) {
					d = price.getPriceSonyBravia55();
					aew.WriteExcel(excelPath,0,1,d);
				}
	}
	
	@SuppressWarnings("static-access")
	public void searchIphone13()throws Exception{
		String name = dataRef[1][0];
		try {
          searchHere.sendKeys(name);
          enterSearch.click();
		  item.getIphone13();
          Thread.sleep(5000);
          d = price.getPriceIphone13();  
          aew.WriteExcel(excelPath,1,1,d);
          Assert.assertEquals("IPhone 13",name);
		}
		catch(org.openqa.selenium.ElementClickInterceptedException f) {
			d = price.getPriceIphone13();
			aew.WriteExcel(excelPath,1,1,d);
		}
    }
	
	@SuppressWarnings("static-access")
	public void searchSonyBravia65() throws Exception{
		String name = dataRef[2][0];
		try {
          searchHere.sendKeys(name);
          enterSearch.click();
          item.getSonyBravia65();
          Thread.sleep(5000);
          d =  price.getPriceSonyBravia65();
          aew.WriteExcel(excelPath,2,1,d);
          Assert.assertEquals("Sony bravia 65",name);
		}
          catch(org.openqa.selenium.ElementClickInterceptedException g) {
        	  d = price.getPriceSonyBravia65();
        	  aew.WriteExcel(excelPath,2,1,d);  	
		}
     }
	
	@SuppressWarnings("static-access")
	public void searchNokiaTV()throws Exception{
		String name = dataRef[3][0];
          searchHere.sendKeys(name);
          enterSearch.click();
          d = "Null";
          aew.WriteExcel(excelPath,3,1,d);
      }
	
}
