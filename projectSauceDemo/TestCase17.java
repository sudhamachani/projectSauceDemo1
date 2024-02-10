package projectSauceDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Assert;

public class TestCase17 {
	// Verify the Cart Icon Updates
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
	public void TestCartIconUpdates() {
		// Verify cart icon initially shows 0 items
		WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		if (cartIcon.getText() != null) {
			System.out.println("cartIcon initially shows empty");
		} else {
			System.out.println("Cart icon does not show 0 items initially");

		}

		// Add an item to the cart
		WebElement addToCart = driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']"));
		addToCart.click();

		// Verify cart icon updates to show 1 item
		if (cartIcon.getText() != null) {
			System.out.println("cartIcon update to show 1 item");
		} else {
			System.out.println("Cart icon does not update to show 1 item");

		}

		// Remove the item from the cart
		WebElement removeButton = driver.findElement(By.xpath("//*[@name='remove-sauce-labs-backpack']"));
		removeButton.click();

		// Verify cart icon updates back to 0 items
		if (cartIcon.getText() != null) {
			System.out.println("cartIcon to show empty");
		} else {
			System.out.println("Cart icon does not update back to 0 items");

		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
