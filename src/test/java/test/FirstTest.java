package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	public static void main(String[] args) {
		//Manual WebDriver manager
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Auto WebDriver Manager
		//.driverVersion() is optional
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.close();
	}

}
