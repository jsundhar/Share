package com.o2.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.o2.pages.*;
import com.o2.data.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;;

public class FsOrderTest {
  WebDriver driver;
  String url = "https://www.o2.co.uk/freesim/";
  @BeforeTest
  
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get(url);
  }
  
  @Test(dataProvider="formData")
  public void phone500mbTest(String fn, String ln, String email, String mobile, String hn, String postcode) {
	  FreesimTariffPage fsTariffPage = new FreesimTariffPage(driver);
	  FsOrderPage fsOrderPage = new FsOrderPage(driver);
	  fsTariffPage.phone500Selection();
	  String ordernumber = fsOrderPage.placeOrder(fn, ln, email, mobile, hn.trim(), postcode);
	  System.out.println("FINAL Page:: order::" + ordernumber);
	
  }
  
  @DataProvider(name="formData")
  public Object[][] formdata () {
	  FormInputsExcel forminputs = new FormInputsExcel();
	 
	 if (forminputs.readData()!=null) {
		 System.out.println("Feeding inputs from Excel");
		 return forminputs.readData(); 
	 }		 
	 else
	 return new Object[][] 
			  {
			  {"firstname","lastname","lastname@test.com","07702934958","260","SL1 4DX"}
			  };

  }


  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
