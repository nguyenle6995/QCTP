package utils;

import org.openqa.selenium.WebDriver;



public class MainMenuPage {
	
	WebDriver driver;
	
	public MainMenuPage(WebDriver driver_p) {
		driver = driver_p;
	}
	
	public boolean compareUrl(String currentUrl, String pageUrl) {
		String tempUrl = currentUrl.replace("/opuscntr/", "@");
		int index = tempUrl.indexOf("@");
		currentUrl = tempUrl.substring(index+1);
		
		return currentUrl.startsWith(pageUrl);
	}
}
