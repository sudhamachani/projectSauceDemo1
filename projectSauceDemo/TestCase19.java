package projectSauceDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase19 {
	// Verify Checkout Summary
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
	public void TestCheckoutSummery() throws Exception {
		// add the items to the cart
		WebElement Item1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		WebElement Item2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
		Item1.click();
		Item2.click();
		// click the cart icon
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		// click on checkout button
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).sendKeys("sudha");
		driver.findElement(By.id("last-name")).sendKeys("machani");
		driver.findElement(By.id("postal-code")).sendKeys("12345");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		// Retrieve items listed in the checkout summary
		List<WebElement> checkoutItems = driver.findElements(By.xpath("//div[@class='cart_list']"));
		// Compare items in the checkout summary with the items added to the cart
		for (WebElement checkoutItem : checkoutItems) {
			String itemName = checkoutItem.findElement(By.className("inventory_item_name")).getText();
			if (itemName.equals(itemName)) {
				System.out.println("Item " + itemName + " is in the cart ");
			} else {
				System.out.println(" Item " + itemName + " is not in the cart ");
			}
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
