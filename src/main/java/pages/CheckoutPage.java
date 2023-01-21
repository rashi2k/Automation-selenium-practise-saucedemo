package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	WebDriver driver;
	
	By firstnameTxt = By.id("first-name");
	By lastnameTxt = By.id("last-name");
	By postalcodeTxt = By.id("postal-code");
	By continueBtn = By.id("continue");
	 
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName(String firstName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(firstnameTxt).sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(lastnameTxt).sendKeys(lastName);
	}
	
	public void setPostalCode(String postalCode) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(postalcodeTxt).sendKeys(postalCode);
	}
	
	public void clickContinueBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(continueBtn).click();
	}
	
}
