package test.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngraveandConfirm {
	WebDriver driver;
	
	@FindBy(css=".addEngravingBtn")
	WebElement addEngraving;
	
	//div.form-element:nth-child(1) > input:nth-child(1)
	@FindBy(css="div.form-element:nth-child(1) > input:nth-child(1)")
	WebElement engravingTitle;
	//div.form-element:nth-child(2) > input:nth-child(1)
	@FindBy(css="div.form-element:nth-child(2) > input:nth-child(1)")
	WebElement engravingSubTitle;
	//button.merchandising:nth-child(1)
	@FindBy(css="button.merchandising:nth-child(1)")
	WebElement btnAddToBag;
	//button.merchandising:nth-child(1)//
	@FindBy(css="button.merchandising:nth-child(1)")
	WebElement btnReviewBag;
	//.saveEngravingText
	//.saveEngravingText
	@FindBy(css=".saveEngravingText")
	WebElement btnSaveEngraving;
	//div.small-6:nth-child(2) > button:nth-child(1)
	@FindBy(css="div.small-6:nth-child(2) > button:nth-child(1)")
	WebElement btnCancelEngraving;
	
	
	
	public EngraveandConfirm(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
	
	public void AddEngraving(String title, String subTitle) throws InterruptedException {
		addEngraving.click();
		engravingTitle.sendKeys(title);
		engravingSubTitle.sendKeys(subTitle);
		Thread.sleep(1000);

		btnSaveEngraving.click();
		
	}
	public void AddtoBag() {
		btnAddToBag.click();
	}
	
	public void ReviewBag() {
		btnReviewBag.click();
	}
}
