package challenges;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import challenges.challenge3.pages.HomePage;
import challenges.challenge3.pages.LoginPage;
import io.netty.util.Timeout;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Challege3 {
	WebDriver driver = new ChromeDriver();

	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);

	@BeforeTest
	void openBrowser() {
//		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterTest
	void closeBrowser() {
//		driver.close();
	}

	@Test
	void loginToApp() {
		lp.loginUsingUN1();
		Assert.assertEquals(hp.isAppLogoVisible(), true);
	}

	@Test
	void selectProduct() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickHighestPricedItem(driver);
	}

	@Test
	void ClickcartAndVerifyItem() {
		hp.clickCart(driver);
		hp.VerifyProductAdded();
	}
}
