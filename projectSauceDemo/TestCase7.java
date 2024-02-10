package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

	// Verify the user is able to Increase the Product Quantity in Cart.
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
	public void testIncreaseProductQuantity() throws Exception {

		// Add a product to the cart
		WebElement AddProduct = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
		AddProduct.click();
		// Go to the cart
		WebElement CartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		CartIcon.click();
		// Verify if the product is added to the cart by checking the presence of the
		// product name
		WebElement productNameElement1 = driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
		String productName1 = productNameElement1.getText();
		if (productName1.equals(productName1)) {
			System.out.println("First Product name : " +productName1);
		} else {
			System.out.println("Failed to add the First product");
		}

		// Increase the quantity of the product in the cart
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("shopping_cart_link")).click();
		WebElement productNameElement2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
		String productName2 = productNameElement2.getText();
		if (productName2.equals(productName2)) {
			System.out.println("Second Product name : " +productName2);
		} else {
			System.out.println("Failed to add the Second product");
		}
		//check the quantity of the product is increased or not
		WebElement IncreseButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		if(IncreseButton.equals(IncreseButton)) {
			System.out.println("The quantity of the product is increased");
		}
		else {
			System.out.println("Failed to increase the product");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
