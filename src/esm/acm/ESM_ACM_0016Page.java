package esm.acm;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TASUtils;

public class ESM_ACM_0016Page {

	// Retrieve Button
	@FindBy(name = "btn_retrive")
	private WebElement btnRetrieveElement;

	// Input Booking Number
	@FindBy(id = "bkg_no")
	private WebElement inputbookingElement;
	
	// select Bound
	@FindBy(id = "io_bnd_cd2")
	private WebElement selectinboundElememt;
	
	// wait
	@FindBy(id = "waitiframe")
	private WebElement waitiframeElememt;


	WebDriver driver;
	JavascriptExecutor jsExe;
	String directUrl;
	WebDriverWait wait;
	int iMsTime = 3000; 

	public ESM_ACM_0016Page(WebDriver driver_p) {
		driver = driver_p;
		jsExe = (JavascriptExecutor) driver;
	}

	public boolean retrieve(String booking){
		boolean booleanReturn = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		inputbookingElement.click();
		inputbookingElement.sendKeys(booking);
		selectinboundElememt.click();
		btnRetrieveElement.click();
		wait.until(ExpectedConditions.invisibilityOf(waitiframeElememt));
		TASUtils.log("Row Num : " + jsExe.executeScript("return sheet1.GetTotalRows()"));
		booleanReturn = (Boolean) jsExe.executeScript("return sheet1.GetTotalRows() > 0");
		return booleanReturn;
	
	}
	

}
