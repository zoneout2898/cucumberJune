package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetup {
	public WebDriver driver;
	public String offerPageProductname;
	public String landingpageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public TestContextSetup() throws IOException
	{
		testBase=new TestBase();
		this.driver=testBase.WebDriverManager();
		pageObjectManager=new PageObjectManager(driver);
		genericUtils=new GenericUtils(driver);

	}

}
