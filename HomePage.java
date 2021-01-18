package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base {
	public WebDriver driver;
	@BeforeTest
	public void startdriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void BasePageNavigation(String username, String password) throws IOException {
		LandingPage l = new LandingPage(driver);

		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername().sendKeys(username);
		lp.enterPassword().sendKeys(password);
		lp.clickLoginButton().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "akansha";
		data[0][1] = "A111111";
		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
