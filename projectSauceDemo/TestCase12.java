package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase12 {

	// Verify the Product Availability
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
	public void TestProductAvailability() throws Exception {
		WebElement ProductTable = driver.findElement(By.xpath("//*[@class='inventory_container']"));
		String ProductAvailable = ProductTable.getText();
		Thread.sleep(1000);

		if (ProductAvailable.contains("Sauce Labs Backpack")) {

			System.out.println("Product is available.");
		} else {
			System.out.println("Product is not available.");
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
