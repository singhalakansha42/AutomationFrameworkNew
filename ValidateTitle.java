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

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void startdriver() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to url");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		Log.info("Driver has been closed");
	}

	@Test
	public void verifyTest() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getFeatureCourseText().getText(), "FEATURED COURSES");
		Log.info("Featired courses heaing should be displayed");
	}

}
