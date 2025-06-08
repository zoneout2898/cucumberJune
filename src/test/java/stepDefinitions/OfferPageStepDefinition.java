package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	


	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		LandingPage lp=testContextSetup.pageObjectManager.getLandingPage();
		lp.selectTopDealsPage();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		testContextSetup.genericUtils.SwitchWindowToChild();
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		OfferPage op=testContextSetup.pageObjectManager.getOfferPage();
		op.searchItem(shortName);
		Thread.sleep(2000);
		//testContextSetup.offerPageProductname=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		testContextSetup.offerPageProductname=op.getProductName();
		
	}
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		
	    Assert.assertEquals(testContextSetup.landingpageProductName, testContextSetup.offerPageProductname);
	}


}
