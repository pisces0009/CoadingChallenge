package test.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AppleCare {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"bag-container\"]/div")
    WebElement applecare;
	
	 public AppleCare(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	   public String appleCare(){

		     return    applecare.getText();
	   }
	   
	  
			 
	

}
