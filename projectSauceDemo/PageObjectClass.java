package projectSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class PageObjectClass {
	WebDriver driver;

	@FindBy(id = "user-name") WebElement uid;
	@FindBy(id = "password")  WebElement pwd;
	@FindBy(id = "login-button")  WebElement Login;

}
