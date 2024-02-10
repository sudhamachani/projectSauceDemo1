package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
	// Verify the user is able to Remove the Product from Cart.

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
	public void testRemoveProductFromCart() throws Exception {

		PageObjectClass p = PageFactory.initElements(driver, PageObjectClass.class);
		p.uid.sendKeys("standard_user");
		p.pwd.sendKeys("secret_sauce");
		p.Login.click();
		Thread.sleep(1000);
		// Add a product to the cart
		driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		// Go to the cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(1000);
		// Verify if the product is added to the cart by checking the presence of the
		// cart icon
		WebElement ProductDescriptionElement = driver.findElement(By.className("inventory_item_desc"));
		if (ProductDescriptionElement.isDisplayed()) {
			System.out.println("Product successfully added to cart!");
		} else {
			System.out.println("Failed to add product to cart!");
		}
		// Remove the product from the cart
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		WebElement ContinueShopping = driver.findElement(By.id("continue-shopping"));
		Thread.sleep(1000);
		if (ContinueShopping.isDisplayed()) {
			System.out.println("Product is successfully removed from the cart!");
		} else {
			System.out.println("Failed to remove the product from the cart!");
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}
