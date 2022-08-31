package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoLoginPage;

public class SauceDemoLoginPageTest {
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		sauceDemoLoginTest();
	}
	
	public static void sauceDemoLoginTest() {
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		driver = new ChromeDriver();
		
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
		
		loginPage.setUsername("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
//		driver.close();
	}

}
