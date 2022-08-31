package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLoginPage {
	
	WebDriver driver = null;
	
	By field_username = By.xpath("//input[@id='user-name']");
	By field_password = By.xpath("//input[@id='password']");
	By button_login = By.xpath("//input[@id='login-button']");
	
	public SauceDemoLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String username) {
		driver.findElement(field_username).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(field_password).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(button_login).click();
	}

}
