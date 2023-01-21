package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	
	By productNameList = By.xpath("//div[@class='inventory_item_name']");
	By checkoutBtn = By.id("checkout");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkCartByProductName(String name) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> productNames = driver.findElements(productNameList);
		 
		for(int i = 0; i< productNames.size(); i++) {
			 if(productNames.get(i).getText().equals(name)) {
				 return true;
			 }
		}
		
		return false;
	}
	
	public void clickCheckoutBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(checkoutBtn).click();
	}

	 
}
