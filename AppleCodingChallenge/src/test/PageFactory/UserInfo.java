package test.PageFactory;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class UserInfo {
	 WebDriver driver;
	 
	 @FindBy(xpath="//*[@id=\"checkout.pickupContact.selfPickupContact.selfContact.address.firstName\"]")
	 WebElement firstName;
	 
	 @FindBy(xpath="//*[@id=\"checkout.pickupContact.selfPickupContact.selfContact.address.lastName\"]")
	 WebElement lastName;
	
	 
	 @FindBy(xpath="//*[@id=\"checkout.pickupContact.selfPickupContact.selfContact.address.emailAddress\"]")
	 WebElement Email;
	
	 @FindBy(xpath="//*[@id=\"checkout.pickupContact.selfPickupContact.selfContact.address.fullDaytimePhone\"]")
	 WebElement phoneNo;
	 
	 @FindBy(xpath="//*[@id=\"checkout-container\"]/div/div[5]/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/button")
	 WebElement continuetopayment;
	 
	 public UserInfo(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 public void UserInformation(String fname, String lname, String email, String no ) throws InterruptedException
	 {
		 firstName.sendKeys(fname);
		 lastName.sendKeys(lname);
		 Email.sendKeys(email);
		 phoneNo.sendKeys(no);
	 }

	    

	  

	        
	        public void ContinueToPayment(){

	            
		         continuetopayment.click();
						

		        }
	    
	    

}
