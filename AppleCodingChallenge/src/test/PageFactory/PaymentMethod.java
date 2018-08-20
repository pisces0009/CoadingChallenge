package test.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	
	   WebDriver driver;
	   @FindBy(css="#checkout\\.billing\\.billingOptions\\.options\\.0-selector > div:nth-child(2) > label:nth-child(1)")
	    WebElement selectpaymentmethod;
	    
	    @FindBy(name="cardNumber")
	    WebElement cardnumber;
	    
	    @FindBy(name="expiration")
	    WebElement cardexpiry;
	    
	    @FindBy(name="securityCode")
	    WebElement cvv;
	    
	    @FindBy(xpath="//*[@id=\"rr-accordion-checkout.billing.billingOptions.options.0_paymentModule.open\"]/div/div/div[2]/div/div[1]/div[1]/div/div")
	    WebElement errormsg;
	    
	    public PaymentMethod(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }

	    

	  

	        public void selectPaymentMethod(){

	            
	         selectpaymentmethod.click();
					

	        }
	        
	        public void AddCardDetails(String cardno,String expiry, String CVV) throws InterruptedException
	        {
	        	cardnumber.sendKeys(cardno);
	        	cardexpiry.sendKeys(expiry);
	        	cvv.sendKeys(CVV);
	        }
	        
	        
	        
	        public String errorMsg() {
	        	return errormsg.getText();
	        }
	        
	       /* public void getCardNo(String strCardNo)
	        {
	        	this.setCardNumber(strCardNo);
	        }*/
	        
	      

}
