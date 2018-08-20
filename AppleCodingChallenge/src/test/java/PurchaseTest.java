package test.java;

import org.testng.annotations.Test;

import test.PageFactory.AppleCare;
import test.PageFactory.Checkout;
import test.PageFactory.CustomizeiPad;
import test.PageFactory.EngraveandConfirm;
import test.PageFactory.HomePage;
import test.PageFactory.PaymentMethod;
import test.PageFactory.UserInfo;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PurchaseTest {
	
	 WebDriver driver;
	 Checkout objCheckout;
	 AppleCare objAppleCare;
	 UserInfo objUserInfo;
	 PaymentMethod objMethod;
	 XSSFWorkbook wb;
	 XSSFSheet userinfo;
	 FileInputStream fis;
	 
	 Map<String, Integer>  headermap = new HashMap<String, Integer>();
	 
	 public  String ReadValue(String s, int row) {
			//sheet1.setActiveCell(new CellAddress(row, headermap.get(s)));
		 System.out.println(s + ":" + headermap.get(s));
			return userinfo.getRow(row).getCell(headermap.get(s)).getStringCellValue();
	}
	 
	 @BeforeTest
	    public void setup(){
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\PRASAD\\Desktop\\S\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASAD\\Desktop\\S\\chromedriver_win32\\chromedriver.exe");
	        driver = new FirefoxDriver();
		    //driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        try {
	        //Open DataSheet
	        File src=new File("./resources/SampleData.xlsx");
	        fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
			//System.out.println(fis.
			userinfo=wb.getSheetAt(0);
			
			Iterator<Row> rowIterator=userinfo.iterator();
			ArrayList<String> list=new ArrayList<String>();
			Row r = rowIterator.next();
			//Read the header row and put in dictionary
			for (int i = 0 ; i < 17; i++) {
				if (r.getCell(i) != null)
				{
					//System.out.println(r.getCell(i).getStringCellValue());
					headermap.put(r.getCell(i).getStringCellValue(), i);
				}
				else
					break;
			}
	        }catch(Exception ex) {
	        	System.out.println(ex.getMessage());
	        }
			
	      
	    }

	
	  @Test
	  public void TestPurchase1Test(){
		 
		 driver.get("https://www.apple.com/");
	        driver.manage().window().maximize();
	        try {
	        HomePage objHomePage1 = new HomePage(driver);
	        objHomePage1.ClickBuyItem(ReadValue("Item", 1));
	           
	        CustomizeiPad objCustomizeIpad = new CustomizeiPad(driver);
	        objCustomizeIpad.SelectFinish(ReadValue("Finish", 1));
	        
	        objCustomizeIpad.SelectStorage(ReadValue("Storage", 1));
	        objCustomizeIpad.SelectConnectivity(ReadValue("Connectivity",1));
	        if (ReadValue("AddAppleCare",1) == "yes") objCustomizeIpad.AddAppleCare();
	        objCustomizeIpad.ContinueWithSelection();
	        EngraveandConfirm objEngraveandConfirm = new EngraveandConfirm(driver);
	        objEngraveandConfirm.AddEngraving(ReadValue("EngravingLine1",1), ReadValue("EngravingLine2",1));
	        objEngraveandConfirm.AddtoBag();
	        objEngraveandConfirm.ReviewBag();
	         
	        Checkout objCheckout = new Checkout(driver);
	        objCheckout.clickOnCheckoutButton();
	        objCheckout.clickOnContinueAsGuest();
	        objCheckout.clickOnPickUp();
	        objCheckout.clickOnPickUpLocation();
	        objCheckout.clickOnContinueToPickupDetails();
	        
	        UserInfo objUserInfo = new UserInfo(driver);
	        objUserInfo.UserInformation(ReadValue("Fname",1), ReadValue("Lname",1), ReadValue("email",1), ReadValue("PhoneNumber",1));
	        Thread.sleep(4000);
	        objUserInfo.ContinueToPayment(); 
	        Thread.sleep(2000);
	        PaymentMethod objMethod = new PaymentMethod(driver);
	        objMethod.selectPaymentMethod();
	        objMethod.AddCardDetails(ReadValue("CCNumber",1), ReadValue("CCExpiry",1), ReadValue("CCCvv",1));
	        
	        
				Thread.sleep(50000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      //  driver.close();
	 }
	  
	 @Test(priority=0)
		 
		 public void test_Test() {
		 

		 PaymentMethod objMthd = new PaymentMethod(driver);
	     Assert.assertTrue(objMthd.errorMsg().contains("Please enter a valid credit card number."));
	    
	     System.out.println("Error Message: Please enter a valid credit card number");
	 }

		 
	  @AfterTest
	  public void cleanup() {
		  try {
		  wb.close();
		  fis.close();
		  }catch(Exception ex) {
			  System.out.println(ex.getMessage());
		  }
	  }
}
