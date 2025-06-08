package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage lp;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.lp=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	    System.out.println(Scenario.class.getName());
	    Assert.assertTrue(lp.getTitleOfLandingPage().contains("GreenKart"));
	    

	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		lp.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingpageProductName=lp.getProductName();
		System.out.println(testContextSetup.landingpageProductName+" is extracted from homepage");
	    
	}
	@And("Added {string} items of the selected product to cart")
	public void  Add_items_product(String quantity)
	{
		lp.incrementQuantity(Integer.parseInt(quantity));
		lp.addToCart();
	}



}
