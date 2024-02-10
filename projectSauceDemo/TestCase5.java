package projectSauceDemo;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 {

	// Verify the user is able to Sort the Products by Price.
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
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
		String[] ProductsPrice = { "$29.99", " $9.99 ", "$15.99", "$49.99", "$7.99", "$15.99" };
		int size = ProductsPrice.length;
		// logic for sorting of price low to high
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < ProductsPrice.length; j++) {
				// compare each  price of element in the array to all the remaining  price of elements
				if (ProductsPrice[i].compareTo(ProductsPrice[j]) > 0) {
					// swapping array elements
					String temp = ProductsPrice[i];
					ProductsPrice[i] = ProductsPrice[j];
					ProductsPrice[j] = temp;
				}
			}
		}
		// print the sorted array in ascending order
		System.out.println(Arrays.toString(ProductsPrice));

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
