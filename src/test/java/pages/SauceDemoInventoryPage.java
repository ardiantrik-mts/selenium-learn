package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SauceDemoInventoryPage {
	
	WebDriver driver = null;
	String counter;
	
	By container_inventoryList = By.xpath("//div[@class=\"inventory_list\"]");
	
	By button_addProduct1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By button_removeProduct1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	
	By button_addProduct2 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	By button_removeProduct2 = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
	
	By badge_counterCart = By.xpath("//span[@class='shopping_cart_badge']");
	By button_cart = By.xpath("//a[@class='shopping_cart_link']");
	
	public SauceDemoInventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCart() {
		driver.findElement(button_cart).click();
	}
	
	public String getCounterCart() {
		try {
	        driver.findElement(badge_counterCart);
	    } catch (NoSuchElementException e) {
	        return null;
	    }
		counter = driver.findElement(badge_counterCart).getText();
		return counter;
	}
	
	public void clickAddProduct1() {
		driver.findElement(button_addProduct1).click();
	}
	
	public void clickRemoveProduct1() {
		driver.findElement(button_removeProduct1).click();
	}
	
	public void clickAddProduct2() {
		driver.findElement(button_addProduct2).click();
	}
	
	public void clickRemoveProduct2() {
		driver.findElement(button_removeProduct2).click();
	}

}
