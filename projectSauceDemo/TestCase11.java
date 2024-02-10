package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase11 {

	// Check whether the user is able to View the Order History.
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
	public void TestToViewOrderHistory() throws Exception {
		driver.findElement(By.xpath("//*[text()='Open Menu']")).click();

		// Find the order history link

		WebElement bodyElement = driver.findElement(By.xpath("//*[@class='bm-menu']"));
		Thread.sleep(1000);
		String bodyText = bodyElement.getText();
		Thread.sleep(1000);

		if (bodyText.contains("order history")) {
			System.out.println("test case is pass");

		} else {
			System.out.println("test case is fail");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
