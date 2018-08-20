package test.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
        this.driver = driver;
    }
	
	public void ClickBuyItem(String itemName) {
		WebElement itembuyLink = driver.findElement(By.cssSelector("."+itemName+" > div:nth-child(2) > a:nth-child(2)"));
		itembuyLink.click();
		
	}

}
