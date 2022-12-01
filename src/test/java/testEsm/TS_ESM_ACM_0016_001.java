package test.java.testEsm;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.runners.MethodSorters;
import esm.acm.ESM_ACM_0016Page;
import utils.MainMenuPage;
import utils.SignOnPage;
import utils.TASUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TS_ESM_ACM_0016_001 {
	public String paramApplicationURL = TASUtils.getServerUrl();
	public String paramDirectUrl = "ESM_ACM_0016.do";
	public String paramUserName = "OPUSADM";
	public String paramPassword = "OPUSADM";
	public String paramOffice = "SINHO";
	public String parambookingnumber = "TUTU00956700";
	
	static WebDriver driver;
	int iMsTime = 1500;
	boolean booleanResult;
	SignOnPage signOnPage = new SignOnPage(driver);
	MainMenuPage mainMenuPage = new MainMenuPage(driver);
	ESM_ACM_0016Page esmacm0016page = new ESM_ACM_0016Page(driver);
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	};
	
	@Test	
	public void step01Navigate() {
		driver.get(paramApplicationURL);
		assertTrue("1. Navigate to " + paramApplicationURL, true);
	}

	@Test
	public void step02Login() {
		PageFactory.initElements(driver, signOnPage);
		booleanResult = signOnPage.login(paramUserName, paramPassword, paramOffice, "OPUS ADMIN");
		assertTrue("2. Login", booleanResult);
	}
	
	@Test
	public void step03GoToESM_ACM_0016() {
		PageFactory.initElements(driver, signOnPage);
		PageFactory.initElements(driver, mainMenuPage);
		driver = signOnPage.getWebDriverForDirectUrl(paramDirectUrl);
		booleanResult = mainMenuPage.compareUrl(driver.getCurrentUrl(), "ESM_ACM_0016.do");
		assertTrue("3. Go to ESM_ACM_0016", booleanResult);
	}
	
	@Test
	public void step04Retrieve() {
		PageFactory.initElements(driver, esmacm0016page);
		booleanResult = esmacm0016page.retrieve(parambookingnumber);
		assertTrue("4. Retrieve failed", booleanResult);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
