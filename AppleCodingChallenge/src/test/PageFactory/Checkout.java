package test.PageFactory;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class Checkout {
	
	WebDriver driver;

    @FindBy(css="#shoppingCart\\.actions\\.checkout")
    WebElement clickOnCheckoutButton;
    
    @FindBy(css="#guest-checkout")
    WebElement clickOnContinueAsGuest;
    
    @FindBy(css="div.as-buttongroup-item:nth-child(2) > label:nth-child(2)")
    WebElement clickOnPickUp;
    
    @FindBy(xpath="//*[@id=\"checkout-container\"]/div/div[5]/div[1]/div[2]/div/div/div[2]/div/div/div/fieldset/div/div[1]/div[1]/div[1]/div/div/div")
    WebElement clickOnPickUpLocation;
    
    @FindBy(css="div.as-l-container:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
    WebElement clickOnContinueToPickupDetails;
    
    
    public Checkout(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public void clickOnCheckoutButton(){

        
        clickOnCheckoutButton.click();
				

       }
    
 public void clickOnContinueAsGuest(){

        
	 clickOnContinueAsGuest.click();
				

       }
 
 public void clickOnPickUp(){

     
	 clickOnPickUp.click();
				

       }
 
public void clickOnPickUpLocation(){

     
	 clickOnPickUpLocation.click();
				

       }

public void clickOnContinueToPickupDetails(){

    
	clickOnContinueToPickupDetails.click();
				

      }


}
