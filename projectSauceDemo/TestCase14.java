package projectSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase14 {

	// Verify the Search Functionality
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
	public void TestSearcFuctionality() {
		WebElement BurgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenuButton.click();
		// Check Weather the search functionality is present or not
		WebElement InsideMenu = BurgerMenuButton.findElement(By.xpath("//*[@class='bm-item-list']"));
		String productName = InsideMenu.getText();
		if (productName.contains("Search Functionality")) {
			System.out.println("Search functionality is present");
		} else {
			System.out.println("Search functionality is not present");
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();

	}

}
