package projectSauceDemo;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase13 {

		// Verify the Filter Functionality
		
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
	public void TestFilterFunctionlity() throws Exception {
		 // Apply a filter (example: 'Price (low to high)')
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		  // Wait for the inventory to be sorted
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        // Get the filtered products
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_container']"));
     // Verify if the products are sorted in descending order (Price (low to high))
        boolean isSorted = true;
        for (int i = 0; i < products.size() - 1; i++) {
            String currentProductName = products.get(i).getText();
            String nextProductName = products.get(i + 1).getText();
            if (currentProductName.compareTo(nextProductName) < 0) {
                isSorted = false;
                break;
            }
        }
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}
	}


