package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase8 {

	// Verify the user is able to Decrease the Product Quantity in Cart
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
	public void testDecreaseProductQuantity() throws Exception {
		// Add the products in the cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")).click();
		Thread.sleep(1000);
		// check the cart icon is increased by 2
		WebElement ProductQuantity1 = driver.findElement(By.xpath("//*[@class='shopping_cart_link']"));
		WebElement IncreasedButton = ProductQuantity1.findElement(By.xpath("//*[text()='2']"));
		if (IncreasedButton.isEnabled() == true) {
			System.out.println("Product quantity in the cart is increased");
		} else {
			System.out.println("Failed to increased the product quantity");
		}

		driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='remove-sauce-labs-bike-light']")).click();
		Thread.sleep(1000);
		WebElement ProductQuantity2 = driver.findElement(By.xpath("//*[@class='shopping_cart_link']"));
		if (ProductQuantity2.isEnabled() == true) {
			System.out.println("Product quantity in the cart is decreased");
		} else {
			System.out.println("Failed to decreased the product quantity");
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
