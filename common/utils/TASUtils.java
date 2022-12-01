package utils;

import java.io.File;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Adds various utilities used by TestProject
 */
public class TASUtils {
	/**
	 * Adds a pause before/after steps based on test and step-specific settings.
	 */
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// console log
	public static void log(Object log) {
		System.out.println(log);
	}

	public static String getServerUrl() {
		return "http://202.20.84.128:7110/opuscntr";
	}

	public static String getDirectUrl(String currentUrl, String directUrl) {
		String findPath = "/opuscntr/";
		int idx = currentUrl.indexOf(findPath);
		String changeUrl = currentUrl.substring(0, idx).concat(findPath).concat(directUrl);
		return changeUrl;
	}

	public static boolean isAlertPresent(WebDriver driver) {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 1 /* timeout in seconds */);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public static boolean isExcelDownloaded(String fileName) {
		boolean booleanReturn = false;
		try {
			sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// For tests in TestProject Manager, downloadPath should be as below.
		// String downloadPath = "C:\\Users\\nguye\\Downloads\\";
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\";
		String downloadFile = downloadPath + fileName;

		File file = new File(downloadFile);
		boolean isExists = file.exists();
		if (isExists) {
			TASUtils.log(fileName + " is present. Checked and will be deleted.");
			file.delete();
			booleanReturn = true;
		} else {
			TASUtils.log("The directory is empty");
		}

		return booleanReturn;
	}

}
