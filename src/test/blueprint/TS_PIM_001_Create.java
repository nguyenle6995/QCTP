package test.blueprint;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import blueprint.UI_PIM_001Page;
import utils.MainMenuPage;
import utils.SignOnPage;
import utils.TASUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TS_PIM_001_Create {
	
	public String paramApplicationURL = TASUtils.getServerUrl();
//	test data
  	String paramUsername = "nguyenlh";  
	String paramPassword = "1111";  	
	String paramScreenId = "UI_PIM_001"; 	
	String paramProject = "Testing";
//	variable
	static WebDriver driver;
	boolean booleanResult;
//	UIs in use
	SignOnPage signOnPage = new SignOnPage(driver);
	MainMenuPage mainMenuPage = new MainMenuPage(driver);
	UI_PIM_001Page pim001Page = new UI_PIM_001Page(driver);
	
//	Before run
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	};
	
//	Run
	@Test	
	public void TC01_Create_New_Task() {
//		Navigation
		driver.get(paramApplicationURL);
		assertTrue("1. Navigate to " + paramApplicationURL+": failed", true);
		
		PageFactory.initElements(driver, signOnPage);
//		Login
		booleanResult = signOnPage.login(paramUsername, paramPassword);
		assertTrue("2. Login: failed", booleanResult);
		
//		Navigate to Req Page
		PageFactory.initElements(driver, signOnPage);
		driver = signOnPage.getWebDriverForDirectUrl(paramScreenId);
		booleanResult = mainMenuPage.compareUrl(driver.getCurrentUrl(), paramScreenId);
		assertTrue("3. Navigate to Requirement Page: failed", booleanResult);
		
//		Select Project
		PageFactory.initElements(driver, pim001Page);
		pim001Page.slctPrjct(paramProject);
		assertTrue("4. Select Project: failed", booleanResult);
		
		// Acces to web site
		
		// Input username
		
		// Input password
	}
		
	
	
//	After run
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
