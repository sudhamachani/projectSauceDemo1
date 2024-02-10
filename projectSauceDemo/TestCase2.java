package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCase2 {

	public static void main(String[] args) throws Exception {
		// Verify the user is able to add the Product to Cart.

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\somum\\OneDrive\\Desktop\\jars\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		PageObjectClass p = PageFactory.initElements(driver, PageObjectClass.class);
		p.uid.sendKeys("standard_user");
		p.pwd.sendKeys("secret_sauce");
		p.Login.click();
		Thread.sleep(1000);
		// Find the 'Add to Cart' button for the first product and click it
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		Thread.sleep(1000);
		// Verify if the product is added to the cart by checking the presence of the cart icon
		 WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
	        if (cartIcon.isDisplayed()) {
	            System.out.println("Product successfully added to cart!");
	        } else {
	            System.out.println("Failed to add product to cart!");
	        }

	        // Close the browser
	        driver.quit();
	    }

	}

