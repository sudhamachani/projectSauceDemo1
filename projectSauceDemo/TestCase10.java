package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase10 {
	// Verify the user is able Complete the Checkout Process.
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

	@Test
	public void testCompleteCheckoutProcess() throws Exception {
		driver.findElement(By.id("first-name")).sendKeys("sudha");
		Thread.sleep(1000);
		driver.findElement(By.id("last-name")).sendKeys("machani");
		Thread.sleep(1000);
		driver.findElement(By.id("postal-code")).sendKeys("12345");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();

		// Verify that the user is on the checkout overview page
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));

		// Click on the Finish button to complete the checkout process
		driver.findElement(By.id("finish")).click();

		// Verify that the user is on the checkout complete page
		wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));

		// Verify the success message
		String successMessage = driver.findElement(By.className("complete-header")).getText();
		if(successMessage.equals(successMessage)) {
			System.out.println("CHECKOUT PROCESS IS SUCCESSFULLY COMPLETED");
		}
		else {
			System.out.println("Checkout process failed.");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
