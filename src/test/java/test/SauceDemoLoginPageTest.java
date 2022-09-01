package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoLoginPage;

public class SauceDemoLoginPageTest {
	WebDriver driver = null;
//	public SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
	
//	public static void main(String[] args) {
//		sauceDemoLoginTest();
//	}
	
	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void navigateSauceDemo() {
		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
	}
	
	@AfterTest
	public void tearDownTest() {
//		driver.close();
		System.out.println("COMPLETED");
	}
	
	@Test(priority = 1)
	public void allEmptyFieldTest() {
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		loginPage.clickLogin();
	}
	
	@Test(priority = 2)
	public void usernameOnlyTest() {
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		loginPage.setUsername("standard_user");
		loginPage.clickLogin();
	}
	
	@Test(priority = 3)
	public void wrongPasswordTest() {
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		loginPage.setUsername("standard_user");
		loginPage.setPassword("123");
		loginPage.clickLogin();
	}
	
	@Test(priority = -1)
	public void successLoginTest() {
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		loginPage.setUsername("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();

	}

}
