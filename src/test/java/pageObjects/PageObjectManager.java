package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public LandingPage getLandingPage()
	{
		LandingPage lp=new LandingPage(driver);
		return lp;
	}
	public OfferPage getOfferPage()
	{
		OfferPage op=new OfferPage(driver);
		return op;
	}
	public CheckoutPage getCheckOutPage()
	{
		CheckoutPage cop=new CheckoutPage(driver);
		return cop;
	}
	

}
