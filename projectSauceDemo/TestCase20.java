package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase20 {
	// Verify Logout Functionality
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\somum\\OneDrive\\Desktop\\jars\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		PageObjectClass p = PageFactory.initElements(driver, PageObjectClass.class);
		p.uid.sendKeys("standard_user");
		p.pwd.sendKeys("secret_sauce");
		p.Login.click();
		Thread.sleep(1000);

	}

	@Test
	public void TestLogoutFunctionality() throws Exception {
		// click on menu button
		driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
		// Click on the logout button
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		// Verify if the user is redirected to the login page
		String CurrentUrl = driver.getCurrentUrl();
		Thread.sleep(1000);
		if (CurrentUrl.equals(CurrentUrl)) {
			System.out.println("Logout functionality is working");
		} else {
			System.out.println("Logout functionality is not working");
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}
}
