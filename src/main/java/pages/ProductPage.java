package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver driver;
	
	By productNameList = By.xpath("//div[@class='inventory_item_name']");
	By productPriceList = By.xpath("//div[@class='inventory_item_price']");
	By productAddToCartButtonList = By.xpath("//div[@class='inventory_item_description']//button");
	By cartBtn = By.xpath("//a[@class='shopping_cart_link']");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductPriceByName(String name) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> productNames = driver.findElements(productNameList);
		List<WebElement> productPrices = driver.findElements(productPriceList);
		for(int i = 0; i< productNames.size(); i++) {
			 if(productNames.get(i).getText().equals(name)) {
				 return productPrices.get(i).getText();
			 }
		}
		
		return null;
	}

	public String addProductByName(String name) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> productNames = driver.findElements(productNameList);
		List<WebElement> productAddToCartButtons= driver.findElements(productAddToCartButtonList);
		for(int i = 0; i< productAddToCartButtons.size(); i++) {
			 if(productNames.get(i).getText().equals(name)) {
				 productAddToCartButtons.get(i).click();
			 }
		}
		
		return null;
	}
	 
	public void clickCartIcon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(cartBtn).click();
	}
}
