package projectSauceDemo;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 {

	// public static void main(String[] args) {
	// Verify the user is able to the Sort Products by Name.
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
	public void TestProductsSortedByName() {
		driver.findElement(By.className("product_sort_container")).click();
		String[] ProductsName = { "Sauce Labs Backpack", "Sauce Labs Bike Light ", "Sauce Labs Fleece Jacket",
				"Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)" };
		int size = ProductsName.length;
		// logic for sorting
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < ProductsName.length; j++) {
				// compare each elements of the array to all the remaining elements
				if (ProductsName[i].compareTo(ProductsName[j]) > 0) {
					// swapping array elements
					String temp = ProductsName[i];
					ProductsName[i] = ProductsName[j];
					ProductsName[j] = temp;
				}
			}
		}
		// print the sorted array in ascending order
		System.out.println(Arrays.toString(ProductsName));

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
