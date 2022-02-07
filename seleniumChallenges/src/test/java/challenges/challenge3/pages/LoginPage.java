package challenges.challenge3.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Reporter;

public class LoginPage {
		@FindBy(xpath = "//input[@id='user-name']")
		private WebElement usernameTF;

		@FindBy(xpath = "//input[@id='password']")
		private WebElement passwordTF;

		@FindBy(xpath = "//input[@id='login-button']")
		private WebElement loginBtn;

		@FindBy(xpath = "//div[@id='login_credentials']")
		private WebElement username1;

		@FindBy(xpath = "//br[2]")
		private WebElement username2;

		@FindBy(xpath = "//br[3]")
		private WebElement username3;

		@FindBy(xpath = "//br[4]")
		private WebElement username4;

		@FindBy(xpath = "//div[@class='login_password']")
		private WebElement password;

		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		private String getUN(int unNo) {
			String org = username1.getText();
			String del = "\n";
			String[] sub = org.split(del);
			return (sub[unNo]);
		}

		private String getPWD() {
			String org = password.getText();
			String del = "\n";
			String[] sub = org.split(del);
			System.out.println(sub[1]);
			return (sub[1]);
		}

		public void loginUsingUN1() {
			usernameTF.sendKeys(getUN(1));
			passwordTF.sendKeys(getPWD());
			loginBtn.click();
		}

		public void loginUsingUN2() {
			usernameTF.sendKeys(getUN(2));
			passwordTF.sendKeys(getPWD());
			loginBtn.click();
		}

		public void loginUsingUN3() {
			usernameTF.sendKeys(getUN(3));
			passwordTF.sendKeys(getPWD());
			loginBtn.click();
		}

		public void loginUsingUN4() {
			usernameTF.sendKeys(getUN(4));
			passwordTF.sendKeys(getPWD());
			loginBtn.click();
		}
	}