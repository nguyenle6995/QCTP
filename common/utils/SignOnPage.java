package utils;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOnPage {

	// username
	@FindBy(id = "username")
	private WebElement usernameTxt;

	// password
	@FindBy(id = "password")
	private WebElement passwordTxt;

	// button login
	@FindBy(id = "submit-btn")
	private WebElement loginBtn;

	// userImg
	@FindBy(id = "menu-user-image")
	private WebElement userImg;

	WebDriver driver;

	public SignOnPage(WebDriver driver_p) {
		driver = driver_p;
	}

	public boolean login(String userName, String password) {
		boolean booleanReturn = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		usernameTxt.sendKeys(userName);
		passwordTxt.sendKeys(password);
		loginBtn.click();
		wait.until(ExpectedConditions.visibilityOf(userImg));
		if (userImg.isDisplayed()) {
			booleanReturn = true;
		}
		return booleanReturn;
	}

	public WebDriver getWebDriverForDirectUrl(String url) {
		TASUtils.sleep(5000);
		;
		String changeDirectUrl = TASUtils.getDirectUrl(driver.getCurrentUrl(), url);
		driver.get(changeDirectUrl);
		return driver;
	}
}
