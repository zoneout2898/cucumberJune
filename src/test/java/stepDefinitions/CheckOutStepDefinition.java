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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckOutStepDefinition {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	CheckoutPage cop;
	
	public CheckOutStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		CheckoutPage cop=testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout() throws InterruptedException
	{
		cop.CheckoutItems();
		Thread.sleep(2000);
	}
	
	@And("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo()
	{
		
		Assert.assertTrue(cop.VerifyPromoBtn());
		Assert.assertTrue(cop.VerifyPlaceOrder());
	}
	//changes made
	//chages reverted



}










