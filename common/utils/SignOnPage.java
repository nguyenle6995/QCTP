package utils;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignOnPage {

	@FindBy(css = "#j_username")
	private WebElement userIdElement;

	@FindBy(css = "#j_password")
	private WebElement userPasswdElement;

	@FindBy(css = "#login_form > button")
	private WebElement btnMainLogInElement;

	@FindBy(css = "#logout_form > span")
	private WebElement btnUserPreferElement;

	@FindBy(css = "#logout_form > div > select")
	private WebElement userOffice;

	@FindBy(css = "body > div > ul > li.login_gnb_05")
	private WebElement menuVesselOprElement;

	WebDriver driver;

	public SignOnPage(WebDriver driver_p) {
		driver = driver_p;
	}
	public boolean login(String userName, String passWord, String office, String displayName) {
		boolean booleanReturn = false;

		// loginElement.click();
		userIdElement.click();
		userIdElement.sendKeys(userName);
		TASUtils.sleep(500);

		userPasswdElement.click();
		userPasswdElement.sendKeys(passWord);
		TASUtils.sleep(500);

		btnMainLogInElement.click();
		TASUtils.sleep(500);

		if (btnUserPreferElement.isDisplayed()) {
			String loginName = btnUserPreferElement.getText();
			if (loginName.equals(displayName)) {

				Select selOfcObj = new Select(userOffice);
				if (selOfcObj.getAllSelectedOptions().get(0).getText() != office) {
					selOfcObj.selectByValue(office);
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
				booleanReturn = true;
			}
		}

		return booleanReturn;
	}
	@Test
	public WebDriver getWebDriverForDirectUrl(String url) {
		TASUtils.sleep(5000);;
		String changeDirectUrl = TASUtils.getDirectUrl(driver.getCurrentUrl(), url);
		driver.get(changeDirectUrl);
		return driver;
	}
}
