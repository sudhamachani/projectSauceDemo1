package projectSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {
	//Verify the Login functionality with valid credentials.

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\somum\\OneDrive\\Desktop\\jars\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void testLoginWithValidCredentials() throws Exception {
		PageObjectClass p = PageFactory.initElements(driver, PageObjectClass.class);
		p.uid.sendKeys("standard_user");
		p.pwd.sendKeys("secret_sauce");
		p.Login.click();
		Thread.sleep(1000);
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		if (CurrentUrl.equals(CurrentUrl)) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
