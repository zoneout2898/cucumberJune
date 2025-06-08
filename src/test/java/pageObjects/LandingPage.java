package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class LandingPage {
	WebDriver driver;
	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By increment=By.cssSelector("a.increment");
	By addToCart=By.cssSelector(".product-action button");
	public LandingPage(WebDriver driver)
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
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	public String getTitleOfLandingPage()
	{
		return driver.getTitle();
	}
	public void incrementQuantity(int quantity)
	{
		int i=quantity-1;
		while(i<=0)
		{
			driver.findElement(increment).click();
		}
	}
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

}
