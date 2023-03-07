package blueprint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UI_PIM_001Page {

	WebDriver driver;
	JavascriptExecutor jsExe;
	String directUrl;

	// Interact Elements
	WebElement prjctCbb;
	List<WebElement> prjctOptns;

	public UI_PIM_001Page(WebDriver driver_p) {
		driver = driver_p;
		jsExe = (JavascriptExecutor) driver;
	}

	public boolean slctPrjct(String prj) {
		boolean booleanReturn = false;
		prjctCbb = driver.findElement(By.xpath("//div[@view_id='projectCbb']//input"));
		prjctCbb.click();
		prjctOptns = driver.findElements(By.xpath("//div[@view_id='$suggest3']//div[@class='webix_scroll_cont']/div"));
		for (WebElement option : prjctOptns) {
			String optnNm = option.getText();
			if (optnNm.equals(prj)) {
				option.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				break;
			}
		}
		String slctdOptn = prjctCbb.getAttribute("value");
		if (slctdOptn.equals(prj))
			booleanReturn = true;

		return booleanReturn;
	}

}