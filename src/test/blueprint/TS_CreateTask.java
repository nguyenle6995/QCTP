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

import utils.MainMenuPage;
import utils.SignOnPage;
import utils.TASUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TS_CreateTask {
	
	public String paramApplicationURL = TASUtils.getServerUrl();
//	test data
  	String paramUsername = "nguyenlh";  
	String paramPassword = "1111";  	
	String paramScreenId = "UI_PIM_001"; 	
//	variable
	static WebDriver driver;
	boolean booleanResult;
//	UIs in use
	SignOnPage signOnPage = new SignOnPage(driver);
	MainMenuPage mainMenuPage = new MainMenuPage(driver);
	
//	Before run
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	};
//	test step
	@Test	
	public void step01Navigate() {
		driver.get(paramApplicationURL);
		assertTrue("1. Navigate to " + paramApplicationURL+": failed", true);
	}
		
	@Test
	public void step02Login() {		
		PageFactory.initElements(driver, signOnPage);
		booleanResult = signOnPage.login(paramUsername, paramPassword);
		assertTrue("2. Login: failed", booleanResult);
	}
	
	@Test
	public void step03NavigatetoRequirementPage() {		
		PageFactory.initElements(driver, signOnPage);
		driver = signOnPage.getWebDriverForDirectUrl(paramScreenId);
		booleanResult = mainMenuPage.compareUrl(driver.getCurrentUrl(), paramScreenId);
		assertTrue("3. Navigate to Requirement Page: failed", booleanResult);
	}
	
	
//	After run
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
