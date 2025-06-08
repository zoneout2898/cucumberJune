package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	WebDriver driver;
	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("tr td:nth-child(1)");
	public OfferPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchItem(String searchItem)
	{
		driver.findElement(search).sendKeys(searchItem);
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

}
