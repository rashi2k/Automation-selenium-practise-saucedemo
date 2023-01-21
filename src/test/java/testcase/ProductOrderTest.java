package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utility.BaseClass;
import utility.DataUtils;

public class ProductOrderTest {

	public static WebDriver driver = null;
	LoginPage objLoginPage;
	ProductPage objProductPage;
	CartPage objCartPage;
	CheckoutPage objCheckoutPage;
	CheckoutOverviewPage objCheckoutOverviewPage;
	Faker faker;

	@BeforeClass
	public void setup() {
		driver = BaseClass.initilize();
		BaseClass.openurl();
	}

	@Test(priority = 1)
	// TC1 : Verifying the checkout functionality with valid data
	public void CheckoutTest() throws InterruptedException {
		faker = new Faker();

		objLoginPage = new LoginPage(driver);
		objProductPage = new ProductPage(driver);
		objCartPage = new CartPage(driver);
		objCheckoutPage = new CheckoutPage(driver);
		objCheckoutOverviewPage = new CheckoutOverviewPage(driver);

		objLoginPage.setUsername(DataUtils.getTestData("TestData", "Username", "Value"));
		objLoginPage.setPassword(DataUtils.getTestData("TestData", "Password", "Value"));
		objLoginPage.clickLoginBtn();

		String actualPrice = objProductPage.getProductPriceByName("Sauce Labs Fleece Jacket");
		Assert.assertEquals(actualPrice, "$49.99");

		// Add to cart Sauce Labs Bolt T-Shirt and Test.allTheThings() T-Shirt (Red)
		objProductPage.addProductByName("Sauce Labs Bolt T-Shirt");
		objProductPage.addProductByName("Test.allTheThings() T-Shirt (Red)");

		objProductPage.clickCartIcon();

		// verify the cart by name
		Assert.assertTrue(objCartPage.checkCartByProductName("Sauce Labs Bolt T-Shirt"), "Product Not Found");
		;
		Assert.assertTrue(objCartPage.checkCartByProductName("Test.allTheThings() T-Shirt (Red)"), "Product Not Found");

		// click checkout
		objCartPage.clickCheckoutBtn();

		// insert first name, last name and postal code
		objCheckoutPage.setFirstName(faker.name().firstName());
		objCheckoutPage.setLastName(faker.name().lastName());
		objCheckoutPage.setPostalCode(faker.address().zipCode());

		// click continue
		objCheckoutPage.clickContinueBtn();
		
		// click finish 
		objCheckoutOverviewPage.clickFinishBtn();
	}
}