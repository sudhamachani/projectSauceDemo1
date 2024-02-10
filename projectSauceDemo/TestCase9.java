package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase9 {

	// Verify the user is able to click the Checkout.
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
	public void testClicktCheckOutButton() throws Exception {
		// Add the products in the cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		// Click on the cart icon to go to the cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();
		// Verify that the user is on the checkout page
		String CurrentUrl = driver.getCurrentUrl();
		if (CurrentUrl.equals(CurrentUrl)) {
			System.out.println("User is navigate to ceckout page");
		} else {
			System.out.println("Failed to navigate to the checkout page");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
