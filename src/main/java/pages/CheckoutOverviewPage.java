package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

	WebDriver driver;
	
	By finishBtn = By.id("finish");
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
 
	public void clickFinishBtn() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(finishBtn).click();
	}
}
