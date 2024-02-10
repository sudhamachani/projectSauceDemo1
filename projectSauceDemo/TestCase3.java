package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class TestCase3 {

	// Verify the Details of the product.
	WebDriver driver;

	@BeforeMethod()
	public void SetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\somum\\OneDrive\\Desktop\\jars\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void TestProductDetails() throws Exception {

		PageObjectClass p = PageFactory.initElements(driver, PageObjectClass.class);
		p.uid.sendKeys("standard_user");
		p.pwd.sendKeys("secret_sauce");
		p.Login.click();
		Thread.sleep(1000);
		// Get details of the product

		WebElement productNameElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		WebElement productDescriptionElement = driver
				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div"));
		WebElement productPriceElement = driver
				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));

		// Print the details of the product
		String productName = productNameElement.getText();
		String productDescription = productDescriptionElement.getText();
		String productPrice = productPriceElement.getText();
		System.out.println("Product Name: " + productName);
		System.out.println("Product Description: " + productDescription);
		System.out.println("Product Price: " + productPrice);
	}

	@AfterMethod
	public void Close() {

		// Close the browser

		driver.quit();
	}
}
