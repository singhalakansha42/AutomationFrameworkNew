package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void startedriver() throws IOException {
		driver = initializeDriver();
		Log.info("Validation Navigation");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void verifyTest() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getnavigation().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
