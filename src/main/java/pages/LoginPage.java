package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	By usernameTxt = By.xpath("//input[@id='user-name']");
	By passwordTxt = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(usernameTxt).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(passwordTxt).sendKeys(password);
	}

	public void clickLoginBtn() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(loginBtn).click();
	}
}
