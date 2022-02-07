package challenges.challenge3.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	List<Float> finalPrices = new ArrayList<Float>();

	@FindBy(xpath = "//button[@class=\"btn btn_primary btn_small btn_inventory\"]/preceding-sibling::div")
	private List<WebElement> prices;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cart;

	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement appLogo;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private WebElement priceVerification;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private float findHighestPrice() {

		for (WebElement price : prices) {
			Float finalPrice = Float.parseFloat(price.getText().substring(1));
			finalPrices.add(finalPrice);
		}
		Collections.sort(finalPrices);
		Collections.reverse(finalPrices);
		return finalPrices.get(0);
	}

	public boolean isAppLogoVisible() {
		return appLogo.isDisplayed();
	}

	public void clickHighestPricedItem(WebDriver driver) {
		WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_item_price' and contains(.,'"
				+ findHighestPrice() + "')]/following-sibling::button"));
		addToCartBtn.click();
	}

	public void clickCart(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(cart));
//		wait.until(ExpectedConditions.elementToBeClickable(cart));
//		cart.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", cart);
	}

	public void VerifyProductAdded() {
		Assert.assertEquals(priceVerification.isDisplayed(), true);
		Assert.assertEquals(priceVerification.getText().contains(String.valueOf(findHighestPrice())), true);

	}

}
