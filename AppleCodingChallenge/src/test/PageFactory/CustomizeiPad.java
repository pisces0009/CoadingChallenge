package test.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizeiPad {
	WebDriver driver;
	
	@FindBy(css=".add-to-cart > button:nth-child(1)")
	WebElement btnContinue;
	@FindBy(css="#applecareplus_add_applecareplus_open")
	WebElement btnAddAppleCare;
	@FindBy(css="#applecareplus_overlay_open")
	WebElement btnAddAppleCareConfirm;
	
	
	  
	public CustomizeiPad(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

  //#dimensionColor-silver #dimensionColor-gold
	public void SelectFinish(String finish) throws Exception{
		WebElement finishElement = driver.findElement(By.cssSelector("#dimensionColor-"+finish));
		finishElement.click();
		Thread.sleep(1000);
	}
	//#Item2-dimensionCapacity-32gb
	public void SelectStorage(String storageoption) throws Exception{
		WebElement storageElement = driver.findElement(By.cssSelector("#Item2-dimensionCapacity-"+storageoption));
		storageElement.click();
		Thread.sleep(1000);
	}
	//#Item3-dimensionConnection-wificell
	public void SelectConnectivity(String connectivityOption) throws Exception{
		WebElement connectivityelement = driver.findElement(By.cssSelector("#Item3-dimensionConnection-"+connectivityOption));
		connectivityelement.click();
		Thread.sleep(1000);
	}
	//#applecareplus_add_applecareplus_open
	public void AddAppleCare() throws Exception{
		btnAddAppleCare.click();
		Thread.sleep(1000);
		btnAddAppleCareConfirm.click();
	}
	
	//.add-to-cart > button:nth-child(1)
	public void ContinueWithSelection() {
		btnContinue.click();
		
	}
	
	public void ConfirmAppleCare() {
		btnAddAppleCareConfirm.click();
	}
}
