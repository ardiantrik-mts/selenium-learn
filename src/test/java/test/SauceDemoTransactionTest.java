package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

public class SauceDemoTransactionTest {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void loginSauceDemo() {
		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
		
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		loginPage.setUsername("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
	}
	
	@AfterMethod
	public void logoutSauceDemo() {
		SauceDemoSideBar sideBar = new SauceDemoSideBar(driver);
		
		sideBar.clickSideBar();
		sideBar.clickResetState();
		driver.navigate().refresh();
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("COMPLETED");
	}
	
	@Test(priority = 1)
	public void addToCartTest() {
		SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver);
		String counter;
		
		inventoryPage.clickAddProduct1();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, "1");
		
		inventoryPage.clickAddProduct2();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, "2");
	}
	
	@Test(priority = 2)
	public void removeFromCartTest() {
		SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver);
		String counter;
		
		inventoryPage.clickAddProduct1();
		inventoryPage.clickAddProduct2();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, "2");
		
		inventoryPage.clickRemoveProduct2();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, "1");
		
		inventoryPage.clickRemoveProduct1();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, null);
	}
	
	@Test(priority = 3)
	public void fullTransactionTest() {
		SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver);
		SauceDemoCartPage cartPage = new SauceDemoCartPage(driver);
		String isComplete, counter;
		
		inventoryPage.clickAddProduct1();
		inventoryPage.clickAddProduct2();
		counter = inventoryPage.getCounterCart();
		Assert.assertEquals(counter, "2");
		inventoryPage.clickCart();
		
		cartPage.clickCheckout();
		
		cartPage.setFirstName("testing");
		cartPage.setLastName("automation");
		cartPage.setPostalCode("9129391");
		cartPage.clickContinue();
		
		cartPage.clickFinish();
		
		isComplete = cartPage.getContainerComplete();
		Assert.assertEquals(isComplete, "complete");
	}
	
	

}
