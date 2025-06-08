package stepDefinitions;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		// TODO Auto-generated constructor stub
		this.testContextSetup=testContextSetup;
	}

	@After
	public void tearDown()
	{
		testContextSetup.driver.quit();
	}
	
	@AfterStep
	public void AddScreeShot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			File sourcePath=((TakesScreenshot)testContextSetup.driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(filecontent, "image/png", "image");
		}
	}

}
